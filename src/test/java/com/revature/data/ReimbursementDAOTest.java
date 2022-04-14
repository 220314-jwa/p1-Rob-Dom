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
	private ReimbursementDAOImpl requestDAO = new ReimbursementDAOImpl();
	private StatusDAO statusDAO = new StatusDAOImpl();
	private EmployeesDAO employeeDAO = new EmployeesDAOImpl();
	private EventDAO eventTypeDAO = new EventDAOImpl();
	private DepartmentDAO departmentDAO = new DepartmentDAOImpl();
	
	private static int request_id;
	private static Employees employee_id;
	private static Event event_type_id;
	private static Status status;
	
	
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testRequestDAOImpl() {
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
