package com.example.financialapp.models;

import java.util.ArrayList;

public class UserModel {
	
	private ArrayList<User> users = new ArrayList<User>();
	
	public UserModel() {
		users.add(new Admin("admin")); // add a default admin user.
	}
	
	public boolean userExists(String username, String password) {
		for (User user : users) {
			if (user.getUsername().equals(username) &&
					user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}