//Gunnar Dulle
//CS 320

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentTest {
	
	//Variables
	private String testId, testDesc;
	private String longId, longDesc;
	private Date testDate, pastDate;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		//Variables
		testId = "1A23456789";
		testDesc = "The description shall be at most fifty characters.";
		testDate = new Date(3925, Calendar.JANUARY, 1);
		longId = "abc123456789";
		longDesc = "This description is too long to be the description for an appointment.";
		pastDate = new Date(0);
	}

	//Constructor Test
	@Test
	void appointmentConstructorTest() {
		Appointment appt = new Appointment(testId, testDate, testDesc);
		assertAll(
				"constructor three",
				() -> assertNotNull(testId, appt.getApptId()),
				() -> assertNotNull(appt.getApptDate()),
				() -> assertNotNull(testDesc, appt.getApptDesc()));
	}
	
	//Getter Tests
	@Test
	void getApptIdTest() {
		Appointment appt = new Appointment(testId, testDate, testDesc);
		Assertions.assertEquals(testId, appt.getApptId());
	}
	
	@Test
	void getApptDateTest() {
		Appointment appt = new Appointment(testId, testDate, testDesc);
		Assertions.assertEquals(testDate, appt.getApptDate());
	}
	
	@Test
	void getApptDescTest() {
		Appointment appt = new Appointment(testId, testDate, testDesc);
		Assertions.assertEquals(testDesc, appt.getApptDesc());
	}
	
	//Setter Tests
	@Test
	void setApptIdTest() {
		Appointment appt = new Appointment(testId, testDate, testDesc);
		appt.setApptId(testId);
		Assertions.assertEquals(testId, appt.getApptId());
	}
	
	@Test
	void setApptDateTest() {
		Appointment appt = new Appointment(testId, testDate, testDesc);
		appt.setApptDate(testDate);
		Assertions.assertEquals(testDate, appt.getApptDate());
	}
	
	@Test
	void setApptDescTest() {
		Appointment appt = new Appointment(testId, testDate, testDesc);
		appt.setApptDesc(testDesc);
		Assertions.assertEquals(testDesc, appt.getApptDesc());
	}
	
	//Setter Null Tests
	@Test
	void nullApptIdTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment(null, testDate, testDesc));
	}
	
	@Test
	void nullApptDateTest() {
		Appointment appt = new Appointment(testId, null, testDesc);
		Assertions.assertThrows(IllegalArgumentException.class, () -> appt.setApptDate(null));
	}
	
	@Test
	void nullTaskDescTest() {
		Appointment appt = new Appointment(testId, testDate, null);
		Assertions.assertThrows(IllegalArgumentException.class, () -> appt.setApptDesc(null));
	}
	
	//Setter too long tests
	@Test
	void longApptIdTest() {
		Appointment appt = new Appointment(longId, testDate, testDesc);
		Assertions.assertThrows(IllegalArgumentException.class, () -> appt.setApptId(longId));
	}
	
	@Test
	void longApptDescTest() {
		Appointment appt = new Appointment(testId, testDate, longDesc);
		Assertions.assertThrows(IllegalArgumentException.class, () -> appt.setApptDesc(longDesc));
	}
	
	//Date in past test
	@Test
	void pastApptDateTest() {
		Appointment appt = new Appointment(testId, pastDate, testDesc);
		Assertions.assertThrows(IllegalArgumentException.class, () -> appt.setApptDate(pastDate));
	}
}
