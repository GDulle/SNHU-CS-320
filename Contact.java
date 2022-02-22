//Gunnar Dulle
//CS 320

public class Contact {
	
	//Variables
	private static final int CONTACT_ID_LENGTH = 10;
	private static final int CONTACT_FNAME_LENGTH = 10;
	private static final int CONTACT_LNAME_LENGTH = 10;
	private static final int CONTACT_PHONE_LENGTH = 10;
	private static final int CONTACT_ADDRESS_LENGTH = 30;
	private static final String EMPTY = "EMPTY";
	private static final String EMPTY_NUM = "0000000000";
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	//Constructors
	Contact() {
		this.contactId = EMPTY;
		this.firstName = EMPTY;
		this.lastName = EMPTY;
		this.phoneNumber = EMPTY_NUM;
		this.address = EMPTY;
	}
	
	Contact(String contactId) {
		setContactId(contactId);
		this.firstName = EMPTY;
		this.lastName = EMPTY;
		this.phoneNumber = EMPTY_NUM;
		this.address = EMPTY;
	}
	
	Contact(String contactId, String firstName) {
		setContactId(contactId);
		setFirstName(firstName);
		this.lastName = EMPTY;
		this.phoneNumber = EMPTY_NUM;
		this.address = EMPTY;
	}
	
	Contact(String contactId, String firstName, String lastName) {
		setContactId(contactId);
		setFirstName(firstName);
		setLastName(lastName);
		this.phoneNumber = EMPTY_NUM;
		this.address = EMPTY;
	}
	
	Contact(String contactId, String firstName,String lastName, String phoneNumber) {
		setContactId(contactId);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		this.address = EMPTY;
	}
	
	Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		setContactId(contactId);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setAddress(address);
	}

	//Getters
	protected String getContactId() {
		return contactId;
	}

	protected String getFirstName() {
		return firstName;
	}

	protected String getLastName() {
		return lastName;
	}

	protected String getPhoneNumber() {
		return phoneNumber;
	}

	protected String getAddress() {
		return address;
	}

	//Setters
	protected void setContactId(String contactId) {
		if (contactId == null) {
			throw new IllegalArgumentException("Contact ID cannot be empty.");
		}
		else if (contactId.length() > CONTACT_ID_LENGTH) {
			throw new IllegalArgumentException("Contact ID cannot be longer than " + CONTACT_ID_LENGTH + " characters.");
		}
		else {
			this.contactId = contactId;
		}
	}

	protected void setFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("First name cannot be empty.");
		}
		else if (firstName.length() > CONTACT_FNAME_LENGTH) {
			throw new IllegalArgumentException("First name cannot be longer than " + CONTACT_FNAME_LENGTH + " characters.");
		}
		else {
			this.firstName = firstName;
		}
	}

	protected void setLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("Last name cannot be empty.");
		}
		else if (lastName.length() > CONTACT_LNAME_LENGTH) {
			throw new IllegalArgumentException("Last name cannot be longer than " + CONTACT_LNAME_LENGTH + " characters.");
		}
		else {
			this.lastName = lastName;
		}
	}

	protected void setPhoneNumber(String phoneNumber) {
		String regex = "[0-9]+";
		if (phoneNumber == null) {
			throw new IllegalArgumentException("Phone number cannot be empty.");
		}
		else if (phoneNumber.length() != CONTACT_PHONE_LENGTH) {
			throw new IllegalArgumentException("Phone number must be " + CONTACT_PHONE_LENGTH + " digits long.");
		}
		else if (!phoneNumber.matches(regex)) {
			throw new IllegalArgumentException("Phone number can only contain digits.");
		}
		else {
			this.phoneNumber = phoneNumber;
		}
	}

	protected void setAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("Address cannot be empty.");
		}
		else if (address.length() > CONTACT_ADDRESS_LENGTH) {
			throw new IllegalArgumentException("Address cannot be longer than " + CONTACT_ADDRESS_LENGTH + " characters.");
		}
		else {
			this.address = address;
		}
	}	
	
}
