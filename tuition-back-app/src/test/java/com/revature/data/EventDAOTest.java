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
	private static EventDAO eventDAO = new EventDAOImpl();
	private static Event testEventType = new Event();
	private static Event testNewEventType = new Event();
	

	@BeforeAll
	public static void setUp() {
		testEventType.setEventName("test");
		Random rand = new Random();
		testNewEventType.setEventName("test" + rand.nextLong());
		testEventType.setEventTypeId(eventDAO.create(testEventType));
	}
	@AfterAll
	public static void cleanUp() throws SQLException{
		eventDAO.delete(testEventType);
	}

	@Test
	public void getByEventTypeIdExists() {
		long id = testEventType.getEventId();
		Event eventType = eventDAO.getById(id);
		assertEquals(testEventType, eventType);
	}
}
