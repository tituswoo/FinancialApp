package com.example.financialapp.models;

import java.util.ArrayList;

public class UserModel {
	
	private static ArrayList<User> users;
	
	static {
		users = new ArrayList<User>();
		users.add(new Admin("admin")); // add a default admin user.
	}
	
	public static boolean userExists(String username, String password) {
		for (User user : users) {
			if (user.getUsername().equals(username) &&
					user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @param newUser - the new user to be added to the user list
	 * @return true if the user was successfully added, false if the user cannot be added
	 */
	public static boolean addUser(User newUser) {
		for(User user: users) {
			if(user.getUsername().equals(newUser.getUsername())) {
				return false;
			}
		}
		return users.add(newUser);
	}
}