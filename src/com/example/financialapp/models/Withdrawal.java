package com.example.financialapp.models;

public class Withdrawal extends Transaction {
	public Withdrawal (double amount, String description, String category) {
		super(-amount, description, category);
	}
}
