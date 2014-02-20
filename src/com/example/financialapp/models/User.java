package com.example.financialapp.models;

public class User {
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	public User() {
		this("admin", "John", "Doe", "1234");
	}
	
	public User(String u, String password) {
		this(u, "John", "Doe", password);
	}
	
	public User(String u) {
		this(u, "firstName", "lastName", "1234");
	}
	
	public User(String u, String f, String l, String pswd) {
		this.username = u;
		firstName = f;
		lastName = l;
		password = pswd;
	}
	
	public String toString() {
		return firstName + ", " + lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String f) {
		firstName = f;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String l) {
		lastName = l;
	}
	
	public void setPassword(String newPswd) {
		password = newPswd;
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
