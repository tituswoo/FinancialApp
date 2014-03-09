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
	
}
