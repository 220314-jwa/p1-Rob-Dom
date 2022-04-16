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

import com.revature.trms.Managers;

public class ManagersDAOTest {
	private static ManagersDAO managerDAO = DAOConnect.getManagersDAO();
	private static Managers testDept = new Managers();
	private static Managers testNewDept = new Managers();
	
	@BeforeAll
	public static void setUp() throws SQLException {
		testDept.setManagerName("test");
		Random rand = new Random();
		testNewDept.setManagerName("test_" + rand.nextLong());
		testDept.setManagerID(managerDAO.create(testDept));
	}
	@AfterAll
	public static void cleanUp() throws SQLException {
		// TODO remove pets in DB with name containing "test"
		managerDAO.delete(testDept);
	}
	@Test
	void testManagersDAOImpl() {
		fail("Not yet implemented");
	}
	@Test
	public void create() {
		fail("Not yet implemented");
	}
}
