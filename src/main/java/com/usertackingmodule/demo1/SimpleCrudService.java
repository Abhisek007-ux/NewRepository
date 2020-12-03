package com.usertackingmodule.demo1;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SimpleCrudService {
	
	public SimpleCrudService() {
		super();
	}
	


	@Autowired
	public SimpleCrudService(final SimpleCrudRepository repo) {
		super();
		this.repo = repo;
	}




	private SimpleCrudRepository repo;
	
	
	public String insertData(@Valid SimpleCrudModel data) {
		
		
		return repo.insertData(data);
	}
	
	public String updateData(int id,@Valid SimpleCrudModel data) {
		return repo.updateData(id,data);
	}
	public String deleteData(int id) {
		return repo.deleteData(id);
	}
	
	public List<StudentWiseReportData> getStudetwiseReport(int id) {
		return repo.getStudetwiseReport(id);
	}
	
	public List<StudentWiseReportData> allStudentsReport(int pageid,int total) {
		return repo.allStudentsReport(pageid,total);
	}
	

}
