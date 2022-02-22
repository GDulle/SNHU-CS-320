//Gunnar Dulle
//CS 320

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	//Variables
	protected String contactIdTest, firstNameTest, lastNameTest, phoneNumberTest, addressTest;
	protected String longContactId, longFirstName, longLastName, longPhoneNumber, shortPhoneNumber, longAddress;

	@BeforeEach
	void setUp() throws Exception {
		contactIdTest = "1A23456789";
		firstNameTest = "Gunnar";
		lastNameTest = "Dulle";
		phoneNumberTest = "1234567890";
		addressTest = "123 Beach Rd Marina CA 93933";
		longContactId = "1A234567890";
		longFirstName = "Finnegan James";
		longLastName = "Dulle-Sicht";
		longPhoneNumber = "123456789012";
		shortPhoneNumber = "12345678";
		longAddress = "4401 General Jim Moore Blvd Seaside CA 93955";
	}

	@Test
	void newContactTest() {
		ContactService service = new ContactService();
		service.newContact();
		assertAll(
				"service 0",
				() -> assertNotNull(service.getContactList().get(0).getContactId()),
				() -> assertEquals("EMPTY", service.getContactList().get(0).getFirstName()),
				() -> assertEquals("EMPTY", service.getContactList().get(0).getLastName()),
				() -> assertEquals("0000000000", service.getContactList().get(0).getPhoneNumber()),
				() -> assertEquals("EMPTY", service.getContactList().get(0).getAddress()));
	}
	
	@Test
	void newContactFirstNameTest() {
		ContactService service = new ContactService();
		service.newContact();
		assertAll(
				"service 1",
				() -> assertNotNull(service.getContactList().get(1).getContactId()),
				() -> assertEquals(firstNameTest, service.getContactList().get(1).getFirstName()),
				() -> assertEquals("EMPTY", service.getContactList().get(1).getLastName()),
				() -> assertEquals("0000000000", service.getContactList().get(1).getPhoneNumber()),
				() -> assertEquals("EMPTY", service.getContactList().get(1).getAddress()));
	}
	
	@Test
	void newContactFullNameTest() {
		ContactService service = new ContactService();
		service.newContact();
		assertAll(
				"service 2",
				() -> assertNotNull(service.getContactList().get(2).getContactId()),
				() -> assertEquals(firstNameTest, service.getContactList().get(2).getFirstName()),
				() -> assertEquals(lastNameTest, service.getContactList().get(2).getLastName()),
				() -> assertEquals("0000000000", service.getContactList().get(2).getPhoneNumber()),
				() -> assertEquals("EMPTY", service.getContactList().get(2).getAddress()));
	}
	
	@Test
	void newContactFullNamePhoneTest() {
		ContactService service = new ContactService();
		service.newContact();
		assertAll(
				"service 3",
				() -> assertNotNull(service.getContactList().get(3).getContactId()),
				() -> assertEquals(firstNameTest, service.getContactList().get(3). getFirstName()),
				() -> assertEquals(lastNameTest, service.getContactList().get(3).getLastName()),
				() -> assertEquals(phoneNumberTest, service.getContactList().get(3).getPhoneNumber()),
				() -> assertEquals("EMPTY", service.getContactList().get(3).getAddress()));
	}
	
	@Test
	void newContactFullNamePhoneAddressTest() {
		ContactService service = new ContactService();
		service.newContact();
		assertAll(
				"service 4",
				() -> assertNotNull(service.getContactList().get(4).getContactId()),
				() -> assertEquals(firstNameTest, service.getContactList().get(4).getFirstName()),
				() -> assertEquals(lastNameTest, service.getContactList().get(4).getLastName()),
				() -> assertEquals(phoneNumberTest, service.getContactList().get(4).getPhoneNumber()),
				() -> assertEquals(addressTest, service.getContactList().get(4).getAddress()));
	}
	
	@Test
	void deleteContactTest() {
		ContactService service = new ContactService();
		service.newContact();
		assertThrows(Exception.class, () -> service.deleteContact(contactIdTest));
		assertAll(() -> service.deleteContact(service.getContactList().get(0).getContactId()));
	}
	
	@Test
	void updateFirstNameTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updateFirstName(service.getContactList().get(0).getContactId(), firstNameTest);
		assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
		assertThrows(IllegalArgumentException.class, () -> service.updateFirstName(service.getContactList().get(0).getContactId(), longFirstName));
		assertThrows(IllegalArgumentException.class, () -> service.updateFirstName(service.getContactList().get(0).getContactId(), null));
		assertThrows(Exception.class, () -> service.updateFirstName(contactIdTest, firstNameTest));
	}
	
	@Test
	void updateLastNameTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updateLastName(service.getContactList().get(0).getContactId(), lastNameTest);
		assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
		assertThrows(IllegalArgumentException.class, () -> service.updateLastName(service.getContactList().get(0).getContactId(), longLastName));
		assertThrows(IllegalArgumentException.class, () -> service.updateLastName(service.getContactList().get(0).getContactId(), null));
		assertThrows(Exception.class, () -> service.updateLastName(contactIdTest, lastNameTest));
	}
	
	@Test
	void updatePhoneNumberTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updatePhoneNumber(service.getContactList().get(0).getContactId(), phoneNumberTest);
		assertEquals(phoneNumberTest, service.getContactList().get(0).getPhoneNumber());
		assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), longPhoneNumber));
		assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), shortPhoneNumber));
		assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), contactIdTest));
		assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), null));
		assertThrows(Exception.class, () -> service.updatePhoneNumber(contactIdTest, phoneNumberTest));
	}
	
	@Test
	void updateAddressTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updateAddress(service.getContactList().get(0).getContactId(), addressTest);
		assertEquals(addressTest, service.getContactList().get(0).getAddress());
		assertThrows(IllegalArgumentException.class, () -> service.updateAddress(service.getContactList().get(0).getContactId(), longAddress));
		assertThrows(IllegalArgumentException.class, () -> service.updateAddress(service.getContactList().get(0).getContactId(), null));
		assertThrows(Exception.class, () -> service.updateAddress(contactIdTest, addressTest));
	}

}
