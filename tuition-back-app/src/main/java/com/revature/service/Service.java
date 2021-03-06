package com.revature.service;
import com.revature.trms.*;
import com.revature.exceptions.IncorrectCredentialsException;
import com.revature.exceptions.RequestAlreadyExistsException;
import com.revature.exceptions.StatusDoesNotExistException;
import java.sql.SQLException;
import java.util.List;

public interface Service {
	public Employees logIn(String username, String password) throws IncorrectCredentialsException, SQLException;
	public int submitRequest(Reimbursement newRequest) throws RequestAlreadyExistsException;
	public Employees statusRequest(Employees employee) throws StatusDoesNotExistException;
	public List<Department> viewDepartmentNames();
	public Reimbursement editReimbursement(Reimbursement requestToEdit);
}
//add in something for the status request