package com.revature.data;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.revature.trms.Employees;
import com.revature.trms.Event;
import com.revature.trms.Reimbursement;
import com.revature.trms.Status;

@ExtendWith(MockitoExtension.class)
public class ReimbursementDAOTest {
	private static ReimbursementDAO reimbusementDAO = DAOConnect.getReimbursementDAO();
	private static Reimbursement testRequest = new Reimbursement();
	private static Reimbursement testNewRequest = new Reimbursement();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		testRequest.setRequestId(123);
		Random rand = new Random();
		testNewRequest.setRequestId(123 + rand.nextInt());
		testRequest.setRequestId(reimbusementDAO.create(testRequest));
	}
	
	@AfterAll
	public static void cleanup() throws SQLException{
		reimbusementDAO.delete(testRequest);
	}

	@Test
	void testReimbursementDAOImpl() {
		fail("Not yet implemented");
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}
	
	@Test
	public void RequestAlreadyExistsException() {
		System.out.println("This request is already being processed!");
	}
}
