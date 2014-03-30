package com.example.financialapp.models;

public class Admin extends User {

	public Admin(String username) {
		super(username);
	}

	public Admin(String username, String first, String last, String password) {
		super(username, first, last, password);
	}
}