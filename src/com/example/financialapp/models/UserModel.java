package com.example.financialapp.models;

import java.util.HashMap;
import java.util.Map;

public class UserModel {
	
	private static Map<String, User> users;
	private static User current;
	
	static {
		users = new HashMap<String, User>(10);
		users.put("admin", new Admin("admin", "John", "Doe", "pass1234")); // adds a default admin user.
		users.put("", new User("", "Vish", "All", ""));
		current = null;
	}
	
	public static boolean usernameExists(String username) {
		return users.get(username) != null;
	}
	/**
	 * 
	 * @param newUser - the new user to be added to the user list
	 * @return true if the user was successfully added, false if the user cannot be added
	 */
	public static boolean addUser(User newUser) {
		
		if (!usernameExists(newUser.getUsername())) {
			users.put(newUser.getUsername(), newUser);
		}
		
		return usernameExists(newUser.getUsername());
	}
	
	/**
	 *  Logs the user into the usermodel
	 * @param username
	 * @param password
	 * @return true if successful login
	 */
	public static boolean login(String username, String password) {
		if (usernameExists(username)) {
			User user = users.get(username);
			current = user;
			return user.getPassword().equals(password);
		}
		return false;
	}
	
	public static User getCurrentUser() {
		return current;
	}
}