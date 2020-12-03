package com.usertackingmodule.demo1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleCrudServiceTest {

	public SimpleCrudServiceTest() {
		super();

	}
	
	@Autowired
	SimpleCrudService service;
     
    @Mock
    SimpleCrudRepository repo;

	

	@Test
	public void testInsertData() {
		
		when(repo.insertData(new SimpleCrudModel("Abhisek", "Delhi", "200-299-12345", new Date(), new Date(),
				25, 31, 2019, "Math", 100, 100, "January"))).thenReturn("Data inserted successfully");

		String data = service.insertData(new SimpleCrudModel("Abhisek", "Delhi",
				"200-299-12345", new Date(), new Date(), 25, 31, 2019, "Math", 100, 100, "January"));
		
		assertEquals("Data inserted successfully",data );

	}

	@Test
	public void testupdateData() {
		
		when(repo.updateData(1, new SimpleCrudModel("Abhisek", "Delhi", "200-299-12345", new Date(),
				new Date(), 25, 31, 2019, "Math", 100, 100, "January"))).thenReturn("Data inserted successfully");

		assertEquals("Data updated successfully", service.updateData(1, new SimpleCrudModel("Abhisek", "Delhi",
				"200-299-12345", new Date(), new Date(), 25, 31, 2019, "Math", 100, 100, "January")));
	}

	@Test
	public void testDeleteData() {
		
		when(repo.deleteData(1)).thenReturn("Data deleted successfully");

		assertEquals("Data deleted successfully", service.deleteData(1));

	}

	@Test
	public void testGetStudetwiseReport() {
		
		List<StudentWiseReportData>listData= new ArrayList<StudentWiseReportData>();
		StudentWiseReportData data=new StudentWiseReportData();
		listData.add(new StudentWiseReportData(1, "Akash", "80", "Physics", "2018"));
		
		when(repo.allStudentsReport(1, 1)).thenReturn(listData);

		assertEquals(1, service.allStudentsReport(1, 1).size());

	}

	@Test
	public void testallStudentsReport() {
		
		when(repo.getStudetwiseReport(1)).thenReturn(null);

		assertNotEquals(null, service.getStudetwiseReport(1));
		
	}

}
