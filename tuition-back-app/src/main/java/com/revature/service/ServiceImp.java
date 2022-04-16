package com.revature.service;

import com.revature.data.*;
import com.revature.exceptions.IncorrectCredentialsException;
import com.revature.exceptions.RequestAlreadyExistsException;
import com.revature.exceptions.StatusDoesNotExistException;
import com.revature.trms.*;
import java.sql.SQLException;
import java.util.List;

public class ServiceImp implements Service{
	private EmployeesDAO empDao = DAOConnect.getEmployeesDAO();
	private ReimbursementDAO reimbursementDAO = DAOConnect.getReimbursementDAO();
	
	public ServiceImp(EmployeesDAO empDao) {
		this.empDao = empDao;
	}
	
	@Override
	public Employees logIn(String username, String password) throws IncorrectCredentialsException, SQLException {
		Employees user = empDao.getByUsername(username);
		if(user!=null) {
			if(password.equals(user.getPassword())) {
				System.out.println("You logged in!");
			}else {
				System.out.println("Your password is wrong!");
			}
		}else {
			System.out.println("User does not exist!");
		}
		return  user;
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

	@Override
	public int submitRequest(Reimbursement newRequest) throws RequestAlreadyExistsException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Reimbursement editReimbursement(Reimbursement requestToEdit) {
		// TODO Auto-generated method stub
		Reimbursement reimbursement = reimbursementDAO.getById(requestToEdit.getRequestId());
		if(reimbursement != null) {
			reimbursementDAO.update(requestToEdit);
			return reimbursementDAO.getById(requestToEdit.getRequestId());
		}
		return reimbursement;
	}
}
