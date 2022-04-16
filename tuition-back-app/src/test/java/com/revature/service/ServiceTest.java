package com.revature.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.*;

import com.revature.data.*;
import com.revature.exceptions.*;
import com.revature.trms.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
	@Mock
	private EmployeesDAO employeeDAO;
	@Mock
	private ReimbursementDAO reimbursementDAO;
	@Mock
	private StatusDAO statusDAO;
	@InjectMocks
	private Service userServ = new ServiceImp();
	
	@Test
	public void logInSuccessfully() throws IncorrectCredentialsException{
		String username = "username";
		String password = "sap";
		
		Employees mockEmployee = new Employees();
		mockEmployee.setUsername(username);
		mockEmployee.setPassword(password);
		
		when(employeeDAO.getByUsername(username)).thenReturn(mockEmployee);
		
		Employees actualEmployee = userServ.logIn(username, password);
		
		assertEquals(mockEmployee, actualEmployee);
	}
	@Test
	public void editRequestSuccessfully() {
		Reimbursement testReimbursement = new Reimbursement();
		Employees testEmployees= new Employees();
		testReimbursement.setRequestId(2);
		testEmployees.setFinalGrade("A");
		
		when(reimbursementDAO.getById(2)).thenReturn(testReimbursement);
		doNothing().when(reimbursementDAO).update(Mockito.any(Reimbursement.class));
		
		Reimbursement actualRequest = userServ.editReimbursement(testReimbursement);
		assertEquals(testReimbursement, actualRequest);
	}
	
	@Test
	public void editRequestDoesNotExist() {
		when(reimbursementDAO.getById(2)).thenReturn(null);
		
		Reimbursement testReimbursement = new Reimbursement();
		testReimbursement.setRequestId(2);
		
		Reimbursement actualRequest = userServ.editReimbursement(testReimbursement);
		
		assertNull(actualRequest);
		verify(reimbursementDAO, times(0)).update(Mockito.any(Reimbursement.class));
	}
}
