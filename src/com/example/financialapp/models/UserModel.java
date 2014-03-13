package com.example.financialapp.models;

import java.util.Date;
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
	/**
	 * Returns the income from one date to the next.
	 * Null for either value represents the most extreme date
	 * in that direction
	 * @param start the starting date
	 * @param end the ending data
	 * @return the income
	 */
	public static double getIncome(Date start, Date end) {
		return current.getIncome(start, end);
	}
	/**
	 * Returns the expenses from one date to the next.
	 * Null for either value represents the most extreme date
	 * in that direction
	 * @param start the starting date
	 * @param end the ending data
	 * @return the expenses
	 */
	public static double getExpenses(Date start, Date end) {
		return current.getExpenses(start, end);
	}
}