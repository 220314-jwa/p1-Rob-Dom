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

import com.revature.trms.Department;

public class DepartmentDAOTest {
	private static DepartmentDAO departmentDAO = DAOConnect.getDepartmentDAO();
	private static Department testDept = new Department();
	private static Department testNewDept = new Department();
	
	@BeforeAll
	public static void setUp() throws SQLException {
		testDept.setDepName("test");
		Random rand = new Random();
		testNewDept.setDepName("test_" + rand.nextLong());
		testDept.setDepID(departmentDAO.create(testDept));
	}
	@AfterAll
	public static void cleanUp() throws SQLException {
		// TODO remove pets in DB with name containing "test"
		departmentDAO.delete(testDept);
	}

	/*
	@Test
	public void testGetByDept_idDoesNotExist() {
		int dept = departmentDAO.getByDepId(0);
		assertNull(testDept);
	}

	@Test
	public void testGetByDept_name() {
		Department department = departmentDAO.getByDepName("thisguy");
		assertNull(testDept);
	}

	@Test
	public void testGetByDept_head_id() {
		Department department = departmentDAO.getBydepHeadID(1);
		assertNull(testDept);
	}
	*/

	@Test
	void testGetById() {
		int id = testDept.getDepID();
		Department department = departmentDAO.getById(id);
		assertEquals(testDept, department);
	}
}
