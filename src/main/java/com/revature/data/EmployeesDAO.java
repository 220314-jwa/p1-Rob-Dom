package com.revature.data;

import com.revature.trms.Employees;

public interface EmployeesDAO extends GenericDAO<Employees>{
	public Employees getByUsername(String username);
}
