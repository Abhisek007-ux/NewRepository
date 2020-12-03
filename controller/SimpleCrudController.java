package com.crudApplication.simplecrudApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudApplication.simplecrudApplication.model.SimpleCrudModel;
import com.crudApplication.simplecrudApplicationcom.service.SimpleCrudService;

@RestController
public class SimpleCrudController {

	@Autowired
	private SimpleCrudService service;
	
	@PostMapping(value="/insertData")
	public ResponseEntity<String>insertData(@RequestBody SimpleCrudModel data){
		return new ResponseEntity<String>(service.insertData(data), HttpStatus.OK);
		
		
	}
}
