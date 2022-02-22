//Gunnar Dulle
//CS 320

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {

	//Variables
	private String uniqueId;
	private ArrayList<Contact> contactList = new ArrayList<Contact>();
	
	//Create unique ID
	private String newUniqueId() {
		return uniqueId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	
	//Search through contact list
	private Contact searchForContact(String contactId) throws Exception {
		int i = 0;
		while (i < contactList.size()) {
			if (contactId.equals(contactList.get(i).getContactId())) {
				return contactList.get(i);
			}
			i++;
		}
		throw new Exception("No contact with this ID.");
	}
	
	//Add new contact for each constructor
	public void newContact() {
		Contact contact = new Contact(newUniqueId());
		contactList.add(contact);
	}
	
	public void newContact(String firstName) {
		Contact contact = new Contact(newUniqueId(), firstName);
		contactList.add(contact);
	}
	
	public void newContact(String firstName, String lastName) {
		Contact contact = new Contact(newUniqueId(), firstName, lastName);
		contactList.add(contact);
	}
	
	public void newContact(String firstName, String lastName, String phoneNumber) {
		Contact contact = new Contact(newUniqueId(), firstName, lastName, phoneNumber);
		contactList.add(contact);
	}
	
	public void newContact(String firstName, String lastName, String phoneNumber, String address) {
		Contact contact = new Contact(newUniqueId(), firstName, lastName, phoneNumber, address);
		contactList.add(contact);
	}
	
	//Deletes contact when given contact ID
	public void deleteContact(String contactId) throws Exception {
		contactList.remove(searchForContact(contactId));
	}
	
	//Update first name in a contact
	public void updateFirstName(String contactId, String firstName) throws Exception {
		searchForContact(contactId).setFirstName(firstName);
	}
	
	//Update last name in a contact
	public void updateLastName(String contactId, String lastName) throws Exception {
		searchForContact(contactId).setLastName(lastName);
	}
	
	//Update phone number for a contact
	public void updatePhoneNumber(String contactId, String phoneNumber) throws Exception {
		searchForContact(contactId).setPhoneNumber(phoneNumber);
	}
	
	//Update address for a contact
	public void updateAddress(String contactId, String address) throws Exception {
		searchForContact(contactId).setAddress(address);
	}
	
	//Get the contact list
	protected List<Contact> getContactList() {
		return contactList;
	}
}
