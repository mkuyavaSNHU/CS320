/*
 * Marisa Kuyava
 * CS-320
 * Milestone 3-2
 * Contact Testing Class 
 * */

package test;

import contact.Contact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;



public class ContactTest {
	
	
	static final String firstName = "John";
	static final String lastName = "Doe";
	static final String phoneNumber = "1234567890";
	static final String address = "United States";
	
	@Test
	@DisplayName("Contact Creation Successful")
	void testContactClass() {
		Contact contactClass = new Contact(firstName,lastName, phoneNumber, address);
		assert(contactClass.getFirstName().equals(firstName)); 
		assert(contactClass.getLastName().equals(lastName));
		assert(contactClass.getPhoneNumber().equals(phoneNumber));
		assert(contactClass.getAddress().equals(address));	
	}
	

	
	@Test
	@DisplayName("First Name has more than 10 charaters.")
	void testContactClassFirstNameMoreThanTen() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		new Contact("01234567890", "LastName", "PhoneNumber", "Address");
		});
	}
	
	
	@Test
	@DisplayName("Last Name has more than 10 charaters.")
	void testContactClassLasttNameMoreThanTen() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FirstName", "01234567890", "phoneNumber", "Address");
			});

	}
	
	@Test
	@DisplayName("Phone Number has more than 10 charaters.")
	void testContactClassPhoneNumberMoreThanTen() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FirstName", "LastName", "01234567890", "Address");
			});
	}
	
	@Test
	@DisplayName("Address has more than 30 charaters.")
	void testContactClassAddressMoreThanThirty() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FirstName", "LastName", "phoneNumber", "0123456789 0123456789 0123456789");
			});
	}
	
	@Test
	@DisplayName("First Name set to null.")
	void testContactClassFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("null", "LastName", "phoneNumber", "Address");
			});
		}
	
	@Test
	@DisplayName("Last Name set to null.")
	void testContactClassLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FirstName", "null", "phoneNumber", "Address");
			});
		}
	
	@Test
	@DisplayName("Phone Number set to null.")
	void testContactClassPhoneNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FirstName", "LastName", "null", "Address");
			});
		}
	
	@Test
	@DisplayName("Address set to null.")
	void testContactClassAdressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FirstName", "LastName", "phoneNumber", "null");
			});
		}
	
	
	}
	

	
	
	
