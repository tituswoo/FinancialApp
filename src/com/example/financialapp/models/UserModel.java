package com.example.financialapp.models;

import java.util.HashMap;
import java.util.Map;

public class UserModel {
	
	private static Map<String, User> users;
	
	static {
		users = new HashMap<String, User>(10);
		users.put("admin", new Admin("admin", "John", "Doe", "pass1234")); // adds a default admin user.
	}
	
	public static boolean usernameExists(String username) {
		return users.get(username) != null;
	}
	
	public static boolean userExists(String username, String pswd) {
		if (usernameExists(username)) {
			User user = users.get(username);
			return user.getPassword().equals(pswd);
		}
		return false;
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
}