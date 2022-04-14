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
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.revature.trms.Employees;

@TestMethodOrder(OrderAnnotation.class)
public class EmployeesDAOTest {
	class EmployeeDAOImplTest {
		private static EmployeesDAO employeeDAO = DAOConnect.getEmployeesDAO();
		private static Employees testEmployee = new Employees();
		private static Employees testNewEmployee = new Employees();

		@BeforeAll
		public static void setUp() {
			testEmployee.setFirstName("test");
			Random rand = new Random();
			testNewEmployee.setFirstName("test_" + rand.nextLong());
			testEmployee.setEmployeeId(employeeDAO.create(testEmployee));
		}
		@AfterAll
		public static void cleanUp() {
			employeeDAO.delete(testEmployee);
		}
		
		@Test
		public void getByIdExists() {
			
			int employee_id = testEmployee.getEmployeeId();
			Employees employee = employeeDAO.getById(employee_id);
			
			assertEquals(testEmployee, employee);
		}
		
		@Test
		public void getByIdDoesNotExist() {
			Employees employee = employeeDAO.getById(0);
			assertNull(employee);
		}
	
	@Test
	public void getByRequestAlreadyExists() {
		//Employees employee = EmployeesDAO.getByUsername("HawkJohnson");
		System.out.println("HawkJohnson");
	}
}
