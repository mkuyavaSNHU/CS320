/*
 * Marisa Kuyava
 * CS-320
 * Milestone 3-2
 * Contact Service Test Class 
 * */
package test;

import contact.Contact;
import contact.ContactService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class ContactServiceTest {
	
	@Test
	@DisplayName("Contact Service Add Contact")
	void testContactServiceClassAddContact() {
		ContactService contactService = new ContactService();
		
		Contact test1contact = new Contact("Jane", "Doe", "0123456789", "United States of America");
		
		contactService.addContact(test1contact);
		System.out.println(test1contact.getContactId());
		
		assertTrue(contactService.contactList.get(0).getContactId().equals("4"));
		
	}
	

	@Test
	@DisplayName("Contact Service Update by ID")
	void testContactServiceClassUpdateById() {
		ContactService contactService = new ContactService();
		
		Contact test2contact = new Contact("James", "Doe", "0123456789", "United States of America");
		Contact test3contact = new Contact("John", "Smith", "0123456789", "United States of America");
		
		contactService.addContact(test2contact);
		contactService.addContact(test3contact);
				
		assertTrue(contactService.updateContactById(test2contact.getContactId(), "Jane", "Doe", "9876543210", "Another adrress")); //Checks that update was successful (All data is valid) 
		assertFalse(contactService.updateContactById(test3contact.getContactId(), "Jane", "Does", "123456789010", "Another adrress")); //Checks that update was unsuccessful due to invalid data (Phone number) 
	}
	

	@Test
	@DisplayName("Contact Service Delete by ID")
	void testContactServiceClassDeleteById() {
		ContactService contactService = new ContactService();
		
		Contact test4contact = new Contact("John", "Doe", "0123456789", "United States of America");
		Contact test5contact = new Contact("James", "Smith", "0123456789", "United States of America");
		
		contactService.addContact(test4contact);
		contactService.addContact(test5contact);
	
		assertTrue(contactService.deleteContact(test4contact.getContactId())); //Checks that deletion was successful 
		assertFalse(contactService.deleteContact("01234567890")); //Checks that deletion was unsuccessful - Not a valid ContactID 
		
	}
	
	
	
}
