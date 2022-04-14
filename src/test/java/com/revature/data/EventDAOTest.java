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

import com.revature.trms.Event;

@ExtendWith(MockitoExtension.class)
public class EventDAOTest {
private EventDAO eventTypeDAO = new EventDAOImpl();
	

	@Test
	void test() {
		fail("Not yet implemented");
	}
}
