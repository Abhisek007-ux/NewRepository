package com.crudApplication.simplecrudApplicationcom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudApplication.simplecrudApplication.model.SimpleCrudModel;
import com.crudApplication.simplecrudApplication.repository.SimpleCrudRepository;

@Service
public class SimpleCrudService {
	
	@Autowired
	private SimpleCrudRepository repo;
	
	
	public String insertData(SimpleCrudModel data) {
		return repo.insertData(data);
	}

}
