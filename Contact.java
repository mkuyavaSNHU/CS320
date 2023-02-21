/*
 * Marisa Kuyava
 * CS-320
 * Milestone 3-2
 * Contact Class - Creates and Stores contacts
 * */
package contact;

import java.util.concurrent.atomic.AtomicLong;

public class Contact {
	
	 private String contactId;
	 private String firstName;
	 private String lastName;
	 private String phoneNumber;
	 private String address;
	 
	 private static final int FILED_MAX_LENGTH = 10;
	 private static final byte ADDRESS_MAX_LENGTH =30;

	 private static AtomicLong idCounter = new AtomicLong();
	 
	 
	 //Getters
	 
	 public String getContactId() {
		 return contactId;
	 }
	 
	 public String getFirstName() {
		 return firstName;
	 }
	 
	 public String getLastName() {
		 return lastName;
	 }
	 
	 public String getPhoneNumber() {
		 return phoneNumber;
	 }
 
	 public String getAddress() {
		 return address;
	 }
	 
	 //Setters and input validation
	 
	 /*
	  * The setContactId method is called when the constructor is called.
	  * The variable is final and does not have a setter so it cannot be changed
	  *  
	  * */
	 protected void setContactId() {
		 this.contactId = String.valueOf(idCounter.getAndIncrement());
	 } 
	 	 
	 public void setFirstName (String firstName){
		 if (firstName == null) {
			 throw new IllegalArgumentException("First name cannot be empty");
		 }else if (firstName.length()> FILED_MAX_LENGTH){
			 throw new IllegalArgumentException("First name cannot exceed " + FILED_MAX_LENGTH + " characters.");
		 }
		 this.firstName = firstName;
	 }
	 
	 public void setLastName (String lastName) {
		 if (lastName == null) {
			 throw new IllegalArgumentException("Last name cannot be empty");
		 }else if (lastName.length()> FILED_MAX_LENGTH){
			 throw new IllegalArgumentException("Last name cannot exceed " + FILED_MAX_LENGTH + " characters.");
		 }
		 this.lastName = lastName;
	 }
	 
	 
	 public void setPhoneNumber (String phoneNumber) {
		 if (phoneNumber == null) {
			 throw new IllegalArgumentException("Phone number cannot be empty");
		 }else if (phoneNumber.length()> FILED_MAX_LENGTH || phoneNumber.length()< FILED_MAX_LENGTH){
			 throw new IllegalArgumentException("Phone number must be " + FILED_MAX_LENGTH + " characters.");
		 }
		 this.phoneNumber = phoneNumber;
	 }
	 
	 public void setAddress (String address) {
		 if (address == null) {
			 throw new IllegalArgumentException("Adress cannot be empty");
		 }else if (address.length()> ADDRESS_MAX_LENGTH ){
			 throw new IllegalArgumentException("Address cannot exceed " + ADDRESS_MAX_LENGTH + " characters.");
		 }
		 this.address = address;
	 }
	 
	 //Constructor
	 public Contact (String firstName, String lastName, String phoneNumber, String address) {
		 setContactId();
		 setFirstName(firstName);
		 setLastName(lastName);
		 setPhoneNumber(phoneNumber);
		 setAddress(address);
	 }
	 //Constructor
	 public Contact (String contactID, String firstName, String lastName, String phoneNumber, String address) {
		 setContactId();
		 setFirstName(firstName);
		 setLastName(lastName);
		 setPhoneNumber(phoneNumber);
		 setAddress(address);
	 }
	 
	 @Override
	 public String toString() {
		 return "Contact Id: " + contactId + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nPhone number: " + phoneNumber + "\nAddress: " + address;
	 }
	 
}
