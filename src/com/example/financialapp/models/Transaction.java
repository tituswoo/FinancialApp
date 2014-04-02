package com.example.financialapp.models;

import java.util.Calendar;
import java.util.Date;

public class Transaction {
	private String description;
	private String category;
	private double amount;
	private Date date;

	public Transaction(double amount, String description, String category) {
		this.amount = amount;
		this.description = description;
		this.category = category;
		date = Calendar.getInstance().getTime();
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
