//Gunnar Dulle
//CS 320

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {
	
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
	void contactTest() {
		Contact contact = new Contact();
		assertAll(
				"constructor",
				() -> assertNotNull(contact.getContactId()),
				() -> assertNotNull(contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void contactIdConstructorTest() {
		Contact contact = new Contact(contactIdTest);
		assertAll(
				"constructor one",
				() -> assertEquals(contactIdTest, contact.getContactId()),
				() -> assertNotNull(contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress()));
		
	}
	
	@Test
	void contactIdFirstNameConstructorTest() {
		Contact contact = new Contact(contactIdTest, firstNameTest);
		assertAll(
				"constructor two",
				() -> assertEquals(contactIdTest, contact.getContactId()),
				() -> assertEquals(firstNameTest, contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void contactIdFullNameConstructorTest() {
		Contact contact = new Contact(contactIdTest, firstNameTest, lastNameTest);
		assertAll(
				"constructor three",
				() -> assertEquals(contactIdTest, contact.getContactId()),
				() -> assertEquals(firstNameTest, contact.getFirstName()),
				() -> assertEquals(lastNameTest, contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void contactIdFullNamePhoneConstructorTest() {
		Contact contact = new Contact(contactIdTest, firstNameTest, lastNameTest, phoneNumberTest);
		assertAll(
				"constructor four",
				() -> assertEquals(contactIdTest, contact.getContactId()),
				() -> assertEquals(firstNameTest, contact.getFirstName()),
				() -> assertEquals(lastNameTest, contact.getLastName()),
				() -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void contactIDFullNamePhoneAddressConstructorTest() {
		Contact contact = new Contact(contactIdTest, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
		assertAll(
				"constructor five",
				() -> assertEquals(contactIdTest, contact.getContactId()),
				() -> assertEquals(firstNameTest, contact.getFirstName()),
				() -> assertEquals(lastNameTest, contact.getLastName()),
				() -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
				() -> assertEquals(addressTest, contact.getAddress()));
	}
	
	@Test
	void setFirstNameTest() {
		Contact contact = new Contact();
		contact.setFirstName(firstNameTest);
		assertAll(
				"first name",
				() -> assertEquals(firstNameTest, contact.getFirstName()),
				() -> assertThrows(IllegalArgumentException.class,
						() -> contact.setFirstName(null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> contact.setFirstName(longFirstName)));
	}
	
	@Test
	void setLastNameTest() {
		Contact contact = new Contact();
		contact.setLastName(lastNameTest);
		assertAll(
				"last name",
				() -> assertEquals(lastNameTest, contact.getFirstName()),
				() -> assertThrows(IllegalArgumentException.class,
						() -> contact.setLastName(null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> contact.setLastName(longLastName)));
	}
	
	@Test
	void setPhoneNumberTest() {
		Contact contact = new Contact();
		contact.setPhoneNumber(phoneNumberTest);
		assertAll(
				"phone number",
				() -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
				() -> assertThrows(IllegalArgumentException.class,
						() -> contact.setPhoneNumber(null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> contact.setPhoneNumber(longPhoneNumber)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> contact.setPhoneNumber(shortPhoneNumber)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> contact.setPhoneNumber(contactIdTest)));
	}
	
	@Test
	void setAddressTest() {
		Contact contact = new Contact();
		contact.setAddress(addressTest);
		assertAll(
				"contact address",
				() -> assertEquals(addressTest, contact.getAddress()),
				() -> assertThrows(IllegalArgumentException.class,
						() -> contact.setAddress(null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> contact.setAddress(longAddress)));
	}
	
	@Test
	void setContactIdTest() {
		Contact contact = new Contact();
		contact.setContactId(contactIdTest);
		assertAll(
				"contact ID",
				() -> assertEquals(contactIdTest, contact.getContactId()),
				() -> assertThrows(IllegalArgumentException.class,
						() -> contact.setContactId(null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> contact.setContactId(longContactId)));
	}
}
