package com.usertackingmodule.demo1;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController


public class SimpleCrudController {
	
//	@Autowired
//	AuthenticationManager authManager;
//	
//	@Autowired
//	MyUserDetailService userDetailService;
//	
//	@Autowired
//	JwtUtil jwt;
//
//	@Autowired
//	AuthResponse auth;
	
	@Autowired
	private SimpleCrudService service;
	
//	@PostMapping(value="/authenticate")
//	public ResponseEntity<AuthResponse>getToken(@RequestBody AuthRequest authReq)throws Exception{
//		try {
//		authManager.authenticate(new UsernamePasswordAuthenticationToken(authReq.getUserName(),authReq.getPassword()));
//		}catch(BadCredentialsException e)
//		{
//			throw new Exception("Bad Credentials",e);
//		}
//		final UserDetails userDetails=userDetailService.loadUserByUsername(authReq.getUserName());
//		
//		auth.setToken(jwt.generateToken(userDetails));
//				
//		return new ResponseEntity<AuthResponse>(auth, HttpStatus.OK);
//		}
	
	@PostMapping(value="/insertData")
	public ResponseEntity<String>insertData(@Valid @RequestBody SimpleCrudModel data){
		try {
		return new ResponseEntity<String>(service.insertData(data), HttpStatus.OK);
		}catch(Exception e)
		{
			return  new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		
		}
	}
	
	@DeleteMapping(value="/deleteData/{id}")
	public ResponseEntity<String>deleteData(@Valid @PathVariable(value="id")int id){
		return new ResponseEntity<String>(service.deleteData(id), HttpStatus.OK);
		
		
	}
	
	@PutMapping(value="/updateData/{id}")
	public ResponseEntity<String>updateData(@Valid @PathVariable(value="id")int id,@RequestBody SimpleCrudModel data){
		return new ResponseEntity<String>(service.updateData(id,data), HttpStatus.OK);
		
		
	}
	
	@GetMapping(value="/getStudetwiseReport/{id}")
	public ResponseEntity<List<StudentWiseReportData>>getStudetwiseReport(@Valid @PathVariable(value="id")int id){
		return new ResponseEntity<List<StudentWiseReportData>>(service.getStudetwiseReport(id), HttpStatus.OK);
		
	}
	
	@GetMapping(value="/getAllStudentsReport/{pageid}")
	public ResponseEntity<List<StudentWiseReportData>>allStudentsReport( @RequestHeader(name = "PageNumber", required = true) int pageNumber,
			 @RequestHeader(name = "Total", required = true) int total,Model m){
		
		   
        if(pageNumber==1){}    
        else{    
        	pageNumber=(pageNumber)*total+1;    
        }    
		return new ResponseEntity<List<StudentWiseReportData>>(service.allStudentsReport(pageNumber,total), HttpStatus.OK);
	}
	
}
