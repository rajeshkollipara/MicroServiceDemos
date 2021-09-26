package com.example.departmentservice.departmentservice;

public class Employee {

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Employee(Integer empId, String firstName, String lastName, String designation, String email,
			Integer departmentId) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.email = email;
		this.departmentId = departmentId;
	}

	public Integer empId;
	public String firstName;
	public String lastName;
	public String designation;
	public String email;
	public Integer departmentId;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Employee Name: " + firstName + " " +lastName + "\r" + "Department ID: " + departmentId + " " +"Email: " + email + " " + "Designation: " + designation;
	}

}
