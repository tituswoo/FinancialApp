package com.example.financialapp.models;

public class Account {
	private TransactionModel transactionHistory;
	private String name;
	private double balance;
	
	public Account(String name) {
		this.name = name;
		balance = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double amount) {
		balance = balance + amount;
	}

	public void deposit(double amount, String description) {
		Transaction t = new Transaction(amount, description);
		transactionHistory.addTransaction(t);
		setBalance(amount);
	}
	
	public void withdraw(double amount, String description) {
		Transaction t = new Transaction(amount, description);
		transactionHistory.addTransaction(t);
		setBalance(amount);
	}
	
}
