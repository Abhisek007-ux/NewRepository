package com.usertackingmodule.demo1;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.BasicAuthDefinition;


@Component
public class StudentWiseReportData {
	
	@JsonIgnore
	private int id;
	private String studentName;
	private String percentageMarksObtained;
	private String subjectName;
	private String correspondingYear;
	

	public StudentWiseReportData() {
		super();
	}
	public StudentWiseReportData(int id, String studentName, String percentageMarksObtained, String subjectName,
			String correspondingYear) {
		
		this.id = id;
		this.studentName = studentName;
		this.percentageMarksObtained = percentageMarksObtained;
		this.subjectName = subjectName;
		this.correspondingYear = correspondingYear;
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
	 * @return the percentageMarksObtained
	 */
	public String getPercentageMarksObtained() {
		return percentageMarksObtained;
	}
	/**
	 * @param percentageMarksObtained the percentageMarksObtained to set
	 */
	public void setPercentageMarksObtained(String percentageMarksObtained) {
		this.percentageMarksObtained = percentageMarksObtained;
	}
	
	/**
	 * @return the correspondingYear
	 */
	public String getCorrespondingYear() {
		return correspondingYear;
	}
	/**
	 * @param correspondingYear the correspondingYear to set
	 */
	public void setCorrespondingYear(String correspondingYear) {
		this.correspondingYear = correspondingYear;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * @return the subjectName
	 */
	public String getSubjectName() {
		return subjectName;
	}
	/**
	 * @param subjectName the subjectName to set
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}


}
