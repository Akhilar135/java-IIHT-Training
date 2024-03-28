package com.gds.ey.employee.serial;

import java.io.Serializable;
import java.time.LocalDate;
//import java.util.Date;

public class Employees implements Serializable{
	
	
	private static final long serialVersionUID = 8538304759779178653L;
	private int id;
	private String name;
	private LocalDate dateOfBirth;
	
	//private Date dob;
	
	private EmployeeType employeeType;
	
	public Employees(int id, String name, LocalDate dateOfBirth, EmployeeType employeeType) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.employeeType = employeeType;
	}
	
	
	

	
//	public Employees(int id, String name, Date dob, EmployeeType employeeType) {
//	super();
//	this.id = id;
//	this.name = name;
//	this.dob = dob;
//	this.employeeType = employeeType;
//}


//	public Date getDob() {
//		return dob;
//	}
//
//	public void setDob(Date dob) {
//		this.dob = dob;
//	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}





	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", employeeType="
				+ employeeType + "]";
	}
	

		
	

}
