package com.revature.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.exceptions.*;
import com.revature.trms.*;

public class ServiceTest {
	private ServiceImp empServTest;
	private Status statusNameTest;
	private Reimbursement requestExistsTest;
	
	@Test
	public void logInSuccessfully() throws IncorrectCredentialsException, SQLException{
		String username = "username";
		String password = "sap";
		
		Employees result = empServTest.logIn(username, password);
		assertEquals(username, result.getUsername());
	}
	@Test
	public void statusCheck() throws StatusDoesNotExistException{
		String statusName = "Approval Pending";
		
		Status result = statusNameTest.statusTest(statusName);
		assertEquals(statusName, result.getStatusName());
		
		
	}
	@Test
	public void ReimbursementCheck() throws RequestAlreadyExistsException{
		String reimbursementCheck = "Request Sent!";
		
		Reimbursement result = Reimbusement.RequestId();
		assertEquals(reimbursementCheck, result.getRequestId());
		
	}
}
