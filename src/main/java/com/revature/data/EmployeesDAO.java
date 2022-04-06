package com.revature.data;

import com.revature.trms.Employees;

public interface EmployeesDAO extends GenericDAO<Employees>{
	public static Employees getByUsername(String username);
}
