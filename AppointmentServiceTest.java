//Gunnar Dulle
//CS 320

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	
	//Variables
	private String testId, testDesc;
	private String longDesc;
	private Date testDate, pastDate;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		//Fill variables
		testId = "1a23456789";
		testDesc = "The description shall be at most fifty characters.";
		longDesc = "This description is too long to be the description for an appointment.";
		testDate = new Date(3925, Calendar.JANUARY, 1);
		pastDate = new Date(0);
	}

	//Test new task variables
	@Test
	void newApptIdTest() {
		AppointmentService service = new AppointmentService();
		service.newAppt(testDate, testDesc);
		Assertions.assertNotNull(service.getApptList().get(0).getApptId());
		Assertions.assertNotEquals(testId, service.getApptList().get(0).getApptId());
	}
		
	@Test
	void newApptDateTest() {
		AppointmentService service = new AppointmentService();
		service.newAppt(testDate, testDesc);
		Assertions.assertNotNull(service.getApptList().get(0).getApptDate());
		Assertions.assertNotEquals("EMPTY", service.getApptList().get(0).getApptDate());
	}
		
	@Test
	void newApptDescTest() {
		AppointmentService service = new AppointmentService();
		service.newAppt(testDate, testDesc);
		Assertions.assertNotNull(service.getApptList().get(0).getApptDesc());
		Assertions.assertNotEquals("EMPTY", service.getApptList().get(0).getApptDesc());
	}
	
	//Test null variables
	@Test
	void newApptNullDateTest() {
		AppointmentService service = new AppointmentService();
		assertThrows(IllegalArgumentException.class, () -> service.newAppt(null, testDesc));
	}
		
	@Test
	void newApptNullDescTest() {
		AppointmentService service = new AppointmentService();
		assertThrows(IllegalArgumentException.class, () -> service.newAppt(testDate, null));
	}
	
	//Test long description
	@Test
	void newApptLongDescTest() {
		AppointmentService service = new AppointmentService();
		assertThrows(IllegalArgumentException.class, () -> service.newAppt(testDate, longDesc));
	}
	
	//Test past date
	@Test
	void newApptPastDateTest() {
		AppointmentService service = new AppointmentService();
		assertThrows(IllegalArgumentException.class, () -> service.newAppt(pastDate, testDesc));
	}
	
	//Test deleting Task
	@Test
	void deleteAppointmentTest() throws Exception {
		AppointmentService service = new AppointmentService();
		service.newAppt(testDate, testDesc);
		assertEquals(1, service.getApptList().size());
		service.deleteAppt(service.getApptList().get(0).getApptId());
		assertEquals(0, service.getApptList().size());
	}
		
	@Test
	void deleteApptNotFoundTest() throws Exception {
		AppointmentService service = new AppointmentService();
		service.newAppt(testDate, testDesc);
		assertEquals(1, service.getApptList().size());
		assertThrows(Exception.class, () -> service.deleteAppt(testId));
		assertEquals(1, service.getApptList().size());
	}
	
	//Unique ID Test
	@Test
	void uniqueIdTest() {
		AppointmentService service = new AppointmentService();
		service.newAppt(testDate, testDesc);
		service.newAppt(testDate, testDesc);
		service.newAppt(testDate, testDesc);
		assertEquals(3, service.getApptList().size());
		assertNotEquals(service.getApptList().get(0).getApptId(), service.getApptList().get(1).getApptId());
		assertNotEquals(service.getApptList().get(0).getApptId(), service.getApptList().get(2).getApptId());
		assertNotEquals(service.getApptList().get(1).getApptId(), service.getApptList().get(2).getApptId());
	}

}
