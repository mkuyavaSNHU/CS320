/*
 * Marisa Kuyava
 * CS-320
 * Milestone 3-2
 * Contact Service Class - Allows adding, updating and deleting Contacts
 * */

package contact;

import java.util.ArrayList;

public class ContactService {
	
	//Array List to hold contacts
	public ArrayList<Contact> contactList;
	
	public ContactService() {
		//Initialize list
		contactList = new ArrayList<>();
	}
	
	//Find Contact by contactID
	public Contact getContactById(String id) {
		for (Contact contactObject : contactList) { //Loops through contactList and checks if contact is already in the list
			if(contactObject.getContactId().equals(id)) { //If contact is already in list does not duplicate 
				return contactObject;
			}
		} 
		return null;
	}

	/*
	 *Add Contact Method 
	 *Loops through contactList and checks if contact is already in the list
	 *If contact is already in list does not duplicate 
	 *If contact is not in the list adds to Array returning true for success and false for failure
	 * */
	public boolean addContact(Contact contact) {
		boolean inContactList = false;
		for (Contact contactObject : contactList) { //Loops through contactList and checks if contact is already in the list
			if(contactObject.equals(contact)) { //If contact is already in list does not duplicate 
				inContactList = true;
				break;
			}
		} 
		
		if(inContactList == false) { //If contact is not in the list adds to Array returning true for success and false for failure
			contactList.add(contact);
			System.out.print("\nContact " + contact.getContactId() + " has been added successfuly");
			return true;
		}
		return false;
	}
	

	
	/*
	 * Delete contact Method with contact ID
	 * Look up contact by Id and remove from list
	 * returns true for success and false for failure
	 * */ 
	public boolean deleteContact(String id) {
		Contact contact = getContactById(id);
		if(contact != null) {
			contactList.remove(contact);
			System.out.print("\nContact " + contact.getContactId() + " has been deleted successfuly");
			return true;
		}
		return false;
	}
	
	/*
	 * Validation Method for contact Updating
	 * Checks if fields exceed max length or are null before update
	 * */
	public boolean validInputCheck(String field, int maxFieldLength){
		return !(field.length() > maxFieldLength || field.equals(""));
		}
	
	/*
	 * Validates input with Validation Method
	 * Updates contact Fields accordingly
	 * Returns true if update is successful
	 * REturns falst if updates fails
	 * */
	public boolean updateContactById(String id, String firstName, String lastName, String phoneNumber, String address) {
		
		//Find contact with contaId
		Contact contact = getContactById(id);
		
		if(	validInputCheck(firstName, 10) &&
			validInputCheck(lastName, 10) &&
			validInputCheck(phoneNumber, 10) &&
			validInputCheck(address, 30)) 
		{
			contact.setFirstName(firstName);
			contact.setLastName(lastName);
			contact.setPhoneNumber(phoneNumber);
			contact.setAddress(address);
			return true;
		}
		return false;
	}
		
	}
	


