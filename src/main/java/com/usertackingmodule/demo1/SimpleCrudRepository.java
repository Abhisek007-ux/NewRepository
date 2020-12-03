package com.usertackingmodule.demo1;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleCrudRepository {

	public SimpleCrudRepository() {
		super();
	}

	@Autowired
	private JdbcTemplate template;

	@Autowired
	private StudentWiseReportData data;
	private String message = "";
	private  int studentId=0;
	private int studentAttendenceId=0;

	public String insertData(final SimpleCrudModel data) {

		try {
			
			insertIntoStudentInfo(data);
			int id=fetchIdFromStudentInfo(data.getContact());
			insertStudentAttendenceInfo(id,data);
			int attendenceId=fetchFromStudentInfo(id);
			InsertStudentMarks(attendenceId,data);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
			message = "failed to insert";
		} catch (Exception e) {
			e.printStackTrace();
			message = "failed to insert";
			return message;
		}
		message = "Data inserted successfully";
		return message;
	}

	private void InsertStudentMarks(final int attendenceId, final SimpleCrudModel data) {
		String query="insert into studentmarks(subjectname,marksobtained,totalmarks,studentattendanceid) values(?,?,?,?)";
		template.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
			
				
				ps.setString(1, AesEncryption.encrypt(data.getSubjectname()));
				ps.setInt(2, data.getMarksobtained());
				ps.setInt(3,data.getTotalmarks());
				ps.setInt(4, attendenceId);
				return ps.execute();
			}
		});
		
		
	}

	private int fetchFromStudentInfo(int id) {
		String query="select id from studentattendance where studentid="+id;
		template.query(query, new RowMapper<Integer>() {
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				 studentAttendenceId=rs.getInt("id");
		return 0;
	}
});
	return studentAttendenceId;
	}

	private void insertStudentAttendenceInfo(final int id, final SimpleCrudModel data) {
		String query="insert into studentattendance(presentdays,totaldaysofmonth,yearofresult,studentid,month) values(?,?,?,?,?)";
		template.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, data.getPresentdays());
				ps.setInt(2, data.getTotaldaysofmonth());
				ps.setInt(3, data.getYearofresult());
				ps.setInt(4, id);
				ps.setString(5, AesEncryption.encrypt(data.getMonth()));
				
				return ps.execute();
			}
		});
		
		
	}

	private int fetchIdFromStudentInfo(String contact) {
		
		String query="select studentid from studentinfo where studentcontact="+"'"+AesEncryption.encrypt(contact)+"'";
		template.query(query, new RowMapper<Integer>() {
				public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
					 studentId=rs.getInt("studentid");
			return 0;
		}
	});
		return studentId;
	}

	

	private void insertIntoStudentInfo(final SimpleCrudModel data) {
		final String query = "insert into studentinfo(studentname,studentaddress,studentcontact,birthdate,entrydate) values(?,?,?,?,?)";
				template.execute(query, new PreparedStatementCallback<Boolean>() {

					public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
						ps.setString(1, AesEncryption.encrypt(data.getName()));
						ps.setString(2, AesEncryption.encrypt(data.getAddress()));
						ps.setString(3, AesEncryption.encrypt(data.getContact()));
						ps.setDate(4, getDob(data.getDob()));
						ps.setDate(5, getDoj());
						
						return ps.execute();
					}
				});
	}

	protected Date getDob(java.util.Date dob) {
		return new java.sql.Date(dob.getTime());
	}

	protected Date getDoj() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	public String updateData(int id, SimpleCrudModel data) {
		String message = "";
		try {
			int attendenceId=fetchFromStudentInfo(id);
			updateStudentMarks(attendenceId,data);
			updateStudentAttendance(id,data);
			updateStudentInfo(id,data);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
			message = "failed to update";
			return message;
		}
		message = "Data updated successfully";
		return message;
	}

	public void updateStudentInfo(final int id, final SimpleCrudModel data) {
		String query="Update studentinfo set studentname=?,studentaddress=?,studentcontact=?,birthdate=?,entrydate=? where studentid=?";
		template.execute(query, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, data.getName());
				ps.setString(2, data.getAddress());
				ps.setString(3, data.getContact());
				ps.setDate(4, getDob(data.getDob()));
				ps.setDate(5, getDoj());
				ps.setInt(6, id);
				
				return ps.executeUpdate();
			}
		});
	}

	private void updateStudentAttendance(final int id, final SimpleCrudModel data) {
		String query="Update studentattendance set presentdays=?,totaldaysofmonth=?,yearofresult=?,month=? where studentid=?";
		template.execute(query, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, data.getPresentdays());
				ps.setInt(2, data.getTotaldaysofmonth());
				ps.setInt(3, data.getYearofresult());
				ps.setString(4, data.getMonth());
				ps.setInt(5, id);
				
				return ps.executeUpdate();
			}
		});
	}

	private void updateStudentMarks(final int attendenceId, final SimpleCrudModel data) {
		String query="Update studentmarks set subjectname=?,marksobtained=?,totalmarks=? where studentattendanceid=?";
		template.execute(query, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, data.getSubjectname());
				ps.setInt(2, data.getMarksobtained());
				ps.setInt(3, data.getTotalmarks());
				ps.setInt(4, attendenceId);
				
				return ps.executeUpdate();
			}
		});
	}

	public String deleteData(int id) {
		String message = "";
		try {
			int attendenceId=fetchFromStudentInfo(id);
			deleteStudentMarks(attendenceId);
			deleteStudentAttendance(id);
			delteStudentDetails(id);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
			message = "failed to delete";
			return message;
		}
		message = "Data deleted successfully";
		return message;
	}

	private void deleteStudentAttendance(final int id) {
		String query="Delete from studentattendance where studentid=?";
		template.execute(query, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
			
				ps.setInt(1, id);
				
				return ps.executeUpdate();
			}
		});
		
	}

	private void deleteStudentMarks(final int attendenceId) {
		String query="Delete from studentmarks where studentattendanceid=?";
		template.execute(query, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
			
				ps.setInt(1, attendenceId);
				
				return ps.executeUpdate();
			}
		});
		
	}

	private void delteStudentDetails(final int id) {
		String query="Delete from studentinfo where studentid=?";
		template.execute(query, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
			
				ps.setInt(1,id);
				
				return ps.executeUpdate();
			}
		});
	}

	public List<StudentWiseReportData> getStudetwiseReport(int id) {
		List<StudentWiseReportData> data;
		try {

			final String query = "SELECT si.studentid,si.studentname,sa.yearofresult,CONCAT(ROUND(((sm.marksobtained/sm.totalmarks)*100)))AS "+
					"Percentage"+
					",sm.subjectname FROM studentinfo si JOIN studentattendance sa ON si.studentid = sa.studentid JOIN studentmarks sm  ON sa.id=sm.studentattendanceid WHERE si.studentid="+
					id;
			data = template.query(query, new RowMapper<StudentWiseReportData>() {
				public StudentWiseReportData mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new StudentWiseReportData(rs.getInt("studentid"), AesEncryption.decrypt(rs.getString("studentname")),
							rs.getString("Percentage"), AesEncryption.decrypt(rs.getString("subjectname")),
									rs.getString("yearofresult"));
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}

		return data;
	}
	
	public  List<StudentWiseReportData> allStudentsReport(int pageid,int total) {
		List<StudentWiseReportData> data;
		try {
			pageid=pageid-1;
			final String query ="SELECT si.studentid,si.studentname,sa.yearofresult,CONCAT(ROUND(((sm.marksobtained/sm.totalmarks)*100)))AS "
					+ "Percentage"
					+ ",sm.subjectname FROM studentinfo si JOIN studentattendance sa ON si.studentid = sa.studentid JOIN studentmarks sm ON sa.id=sm.studentattendanceid"
					+ " LIMIT "+ pageid
					+","+total;
			data = template.query(query, new RowMapper<StudentWiseReportData>() {
				public StudentWiseReportData mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new StudentWiseReportData(rs.getInt("studentid"), AesEncryption.decrypt(rs.getString("studentname")),
						rs.getString("Percentage"), AesEncryption.decrypt(rs.getString("subjectname")),
									rs.getString("yearofresult"));
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		
		return data;
	}


}
