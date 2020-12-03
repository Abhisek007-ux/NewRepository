package com.crudApplication.simplecrudApplication.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crudApplication.simplecrudApplication.model.SimpleCrudModel;

@Repository
public class SimpleCrudRepository {

	@Autowired
	private JdbcTemplate template;

	public String insertData(SimpleCrudModel data) {
		String message="";
		try {	   
		final String query="INSERT INTO studentinfo (studentid, studentname, studentaddress, studentcontact)VALUES"+"("+data.getStudentid()+
		","+ "'"+data.getStudentName()+"'"+","+ "'"+data.getStudentAddress()+"'"+","+"'"+data.getStudentContact()+"'"+")";
		
		final String query1="INSERT INTO studentattendance (id, presentdays, absentdays, studentid)VALUES"+"("+data.getId()+","+data.getPresentdays()+","+ data.getAbsentdays()+","
		+data.getStudentid()+")";
		
		
		final String query2="INSERT INTO studentmarks (marksid, subjectname, marksobtained, totalmarks,yearofresult)VALUES"+ "("+data.getMarksid()+","+data.getSubjectname()+","+ 
		data.getMarksobtained()+","+data.getTotalmarks()+","+data.getYearofresult()+")";
			
			template.update(query);
			template.update(query1);
			template.update(query2);
		}
			catch(DataAccessException e)
			{
				e.printStackTrace();
				message="failed to update";
			}
			message="Data updated successfully";	
			return message;
	}
}
