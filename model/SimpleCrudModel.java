package com.crudApplication.simplecrudApplication.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.springframework.stereotype.Component;

@Component
public class SimpleCrudModel {
	
	@Positive
	private int studentid;
	
	@NotBlank
	private String studentName;
	
	@NotBlank
	private String studentAddress;
	
	@NotBlank
	private String studentContact;
	
	@Positive
	private int id;
	
	@NotBlank
	private String presentdays;
	
	@NotBlank
	private String absentdays;
	
	@Positive
	private int marksid;
	
	@NotBlank
	private String subjectname;
	
	@Positive
	private int marksobtained;
	
	@Positive
	private int totalmarks;
	
	@Positive
	private int yearofresult;
	
	
	public SimpleCrudModel() {
		super();
	}
	
	public SimpleCrudModel(int studentid, String studentName, String studentAddress, String studentContact, int id,
			String presentdays, String absentdays, int marksid, String subjectname, int marksobtained, int totalmarks,
			int yearofresult) {
		super();
		this.studentid = studentid;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.studentContact = studentContact;
		this.id = id;
		this.presentdays = presentdays;
		this.absentdays = absentdays;
		this.marksid = marksid;
		this.subjectname = subjectname;
		this.marksobtained = marksobtained;
		this.totalmarks = totalmarks;
		this.yearofresult = yearofresult;
	}

	/**
	 * @return the studentid
	 */
	public int getStudentid() {
		return studentid;
	}
	/**
	 * @param studentid the studentid to set
	 */
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * @return the studentAddress
	 */
	public String getStudentAddress() {
		return studentAddress;
	}
	/**
	 * @param studentAddress the studentAddress to set
	 */
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	/**
	 * @return the studentContact
	 */
	public String getStudentContact() {
		return studentContact;
	}
	/**
	 * @param studentContact the studentContact to set
	 */
	public void setStudentContact(String studentContact) {
		this.studentContact = studentContact;
	}
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the presentdays
	 */
	public String getPresentdays() {
		return presentdays;
	}

	/**
	 * @param presentdays the presentdays to set
	 */
	public void setPresentdays(String presentdays) {
		this.presentdays = presentdays;
	}

	/**
	 * @return the absentdays
	 */
	public String getAbsentdays() {
		return absentdays;
	}

	/**
	 * @param absentdays the absentdays to set
	 */
	public void setAbsentdays(String absentdays) {
		this.absentdays = absentdays;
	}

	/**
	 * @return the marksid
	 */
	public int getMarksid() {
		return marksid;
	}

	/**
	 * @param marksid the marksid to set
	 */
	public void setMarksid(int marksid) {
		this.marksid = marksid;
	}

	/**
	 * @return the subjectname
	 */
	public String getSubjectname() {
		return subjectname;
	}

	/**
	 * @param subjectname the subjectname to set
	 */
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	/**
	 * @return the marksobtained
	 */
	public int getMarksobtained() {
		return marksobtained;
	}

	/**
	 * @param marksobtained the marksobtained to set
	 */
	public void setMarksobtained(int marksobtained) {
		this.marksobtained = marksobtained;
	}

	/**
	 * @return the totalmarks
	 */
	public int getTotalmarks() {
		return totalmarks;
	}

	/**
	 * @param totalmarks the totalmarks to set
	 */
	public void setTotalmarks(int totalmarks) {
		this.totalmarks = totalmarks;
	}

	/**
	 * @return the yearofresult
	 */
	public int getYearofresult() {
		return yearofresult;
	}

	/**
	 * @param yearofresult the yearofresult to set
	 */
	public void setYearofresult(int yearofresult) {
		this.yearofresult = yearofresult;
	}

	@Override
	public String toString() {
		return "SimpleCrudModel [studentid=" + studentid + ", studentName=" + studentName + ", studentAddress="
				+ studentAddress + ", studentContact=" + studentContact + "]";
	}
	
	

}
