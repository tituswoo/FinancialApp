package com.example.financialapp.models;

import junit.framework.TestCase;

/**
 * Testing the User Model class. Instead of just testing one method, I tested a
 * bunch of them to see if they all work together correctly.
 * 
 * @author Titus Woo
 * 
 */
public class UserModelTests extends TestCase {
	public void setUp() {
		UserModel.login("John", "Doe");
	}

	public void testFailedLogin() {
		boolean success = UserModel.login("John", "Doe");
		assertFalse(success);

		boolean success2 = UserModel.login("admin", "pass");
		assertFalse(success2);
	}

	public void testDefaultUser() {
		String fName = UserModel.getCurrentUser().getFirstName();
		String lName = UserModel.getCurrentUser().getLastName();

		assertEquals("John", fName);
		assertEquals("Doe", lName);
	}

	public void testSuccessfulLogin() {
		boolean success = UserModel.login("admin", "pass1234");
		assertTrue(success);

		boolean success2 = UserModel.login("admin", "fakePass");
		assertFalse(success2);
	}

	public void testAddNewUser() {
		boolean addedUser = UserModel.addUser(new User("titus", "pswd"));
		assertTrue(addedUser);

		boolean loggedInNewUser = UserModel.login("titus", "pswd");
		assertTrue(loggedInNewUser);
	}

	public void testUsernameExists() {
		boolean usernameExists = UserModel.usernameExists("titus");
		assertTrue(usernameExists);

		boolean usernameExists2 = UserModel.usernameExists("admin");
		assertTrue(usernameExists2);

		boolean usernameExists3 = UserModel.usernameExists("howdy");
		assertFalse(usernameExists3);
	}
}
