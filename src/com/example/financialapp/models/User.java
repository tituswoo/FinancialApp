package com.example.financialapp.models;

public class User {
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	public User() {
		this("admin", "John", "Doe", "1234");
	}
	
	public User(String username, String password) {
		this(username, "John", "Doe", password);
	}
	
	public User(String username) {
		this(username, "firstName", "lastName", "1234");
	}
	
	public User(String username, String first, String last, String pass) {
		this.username = username;
		firstName = first;
		lastName = last;
		password = pass;
	}
	
	public String toString() {
		return firstName + ", " + lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String first) {
		firstName = first;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String last) {
		lastName = last;
	}
	
	public void setPassword(String newPass) {
		password = newPass;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String newUsername) {
		username = newUsername;
	}
}
