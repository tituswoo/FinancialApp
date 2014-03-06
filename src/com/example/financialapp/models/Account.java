package com.example.financialapp.models;

public class Account {
	private TransactionModel transactionHistory;
	private String name;
	
	public Account(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public void deposit(double amount, String description) {
		Transaction t = new Transaction(amount, description);
		transactionHistory.addTransaction(t);
	}
	
}
