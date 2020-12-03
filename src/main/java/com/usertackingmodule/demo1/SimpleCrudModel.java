package com.usertackingmodule.demo1;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class SimpleCrudModel {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String address;
	
	@NotBlank
	@Size(min=10)
	private String contact;
	
	@DateTimeFormat(pattern = "dd.MM.yy")
	private Date dob;

	private Date doj;
	
	@NotNull
	private int presentdays;
	
	@NotNull
	private int totaldaysofmonth;
	
	@NotNull
	private int yearofresult;
	
	@NotBlank
	private String subjectname;
	
	@NotNull	
	private int marksobtained;
	
	@NotNull	
	private int totalmarks;
	
	@NotBlank
	private String  month;
	
	public SimpleCrudModel() {
		super();
	}

	public SimpleCrudModel(String name, String address, String contact, Date dob, Date doj, int presentdays,
			int totaldaysofmonth, int yearofresult, String subjectname, int marksobtained, int totalmarks,
			String month) {
		super();
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.dob = dob;
		this.doj = doj;
		this.presentdays = presentdays;
		this.totaldaysofmonth = totaldaysofmonth;
		this.yearofresult = yearofresult;
		this.subjectname = subjectname;
		this.marksobtained = marksobtained;
		this.totalmarks = totalmarks;
		this.month = month;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the doj
	 */
	public Date getDoj() {
		return doj;
	}

	/**
	 * @param doj the doj to set
	 */
	public void setDoj(Date doj) {
		this.doj = doj;
	}

	/**
	 * @return the presentdays
	 */
	public int getPresentdays() {
		return presentdays;
	}

	/**
	 * @param presentdays the presentdays to set
	 */
	public void setPresentdays(int presentdays) {
		this.presentdays = presentdays;
	}

	/**
	 * @return the totaldaysofmonth
	 */
	public int getTotaldaysofmonth() {
		return totaldaysofmonth;
	}

	/**
	 * @param totaldaysofmonth the totaldaysofmonth to set
	 */
	public void setTotaldaysofmonth(int totaldaysofmonth) {
		this.totaldaysofmonth = totaldaysofmonth;
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
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}


}
