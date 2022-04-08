package com.revature.trms;

public class Employees {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String submitRequest;
	private int managerId;
	private int deptId;
	private int finalGrade;
	private String username;
	private String password;
	public Employees() {
		employeeId = 0;
		firstName="";
		lastName="";
		submitRequest="";
		managerId=0;
		deptId=0;
		finalGrade=0;
		username="";
		password="";
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(int finalGrade) {
		this.finalGrade = finalGrade;
	}

	public String getSubmitRequest() {
		return submitRequest;
	}

	public void setSubmitRequest(String submitRequest) {
		this.submitRequest = submitRequest;
	}
	
	
}
