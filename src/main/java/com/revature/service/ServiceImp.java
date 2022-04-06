package com.revature.service;

import com.revature.data.*;
import com.revature.exceptions.IncorrectCredentialsException;
import com.revature.exceptions.StatusDoesNotExistException;
import com.revature.trms.*;
import java.sql.SQLException;
import java.util.List;

public class ServiceImp implements Service{
	private EmployeesDAOImpl empDao;
	
	public ServiceImp(EmployeesDAOImpl empDao) {
		this.empDao = empDao;
	}
	
	@Override
	public Employees logIn(String username, String password) throws IncorrectCredentialsException, SQLException {
		return null;
	}
	@Override
	public Employees statusRequest(Employees employee) throws StatusDoesNotExistException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Department> viewDepartmentNames() {
		// TODO Auto-generated method stub
		return null;
	}
}
