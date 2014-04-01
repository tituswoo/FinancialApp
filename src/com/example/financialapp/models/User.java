package com.example.financialapp.models;

import java.util.Date;

public class User {

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	//private AccountModel accounts;

	public User() {
		this("admin", "John", "Doe", "1234");
	}

	public User(String u, String password) {
		this(u, "John", "Doe", password);
	}

	public User(String u) {
		this(u, "firstName", "lastName", "1234");
	}

	public User(String username, String firstName, String lastName,
			String password) {
		this.username = username.trim();
		this.firstName = firstName.trim();
		this.lastName = lastName.trim();
		this.password = password;
		//accounts = new SimpleAccountModel();
	}

	/*public double getIncome(Date start, Date end) {
		return accounts.getIncome(this, start, end);
	}

	public double getIncomeSource(String category, Date start, Date end) {
		return accounts.getIncomeSource(this, category, start, end);
	}

	public double getExpenses(Date start, Date end) {
		return accounts.getExpenses(this, start, end);
	}

	public double getFoodExpense(Date start, Date end) {
		return accounts.getFoodExpense(this, start, end);
	}

	public double getRentExpense(Date start, Date end) {
		return accounts.getRentExpense(this, start, end);
	}

	public double getEntertainmentExpense(Date start, Date end) {
		return accounts.getEntertainmentExpense(this, start, end);
	}

	public double getClothingExpense(Date start, Date end) {
		return accounts.getClothingExpense(this, start, end);
	}

	public double getOtherExpense(Date start, Date end) {
		return accounts.getOtherExpense(this, start, end);
	}

	public double getTotalExpense(Date start, Date end) {
		return accounts.getTotalExpense(this, start, end);
	}

	public AccountModel getAccountModel() {
		return accounts;
	}*/

	public String toString() {
		return username + "(" + firstName + " " + lastName + ")";
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
