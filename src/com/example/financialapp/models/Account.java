package com.example.financialapp.models;

import java.util.ArrayList;
import java.util.Date;

public class Account {
	private TransactionModel history;
	private String name;
	
	public Account(String name) {
		history = new SimpleTransactionModel();
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void add(Transaction t) {
		history.add(t);
	}
	
	public double getBalance() {
		return history.getBalance();
	}
	
	public double getIncome(Date start, Date end) {
		ArrayList<Deposit> deposits = history.getDeposits();
		double sum = 0;
		for(Deposit d : deposits) {
			int startCompare, endCompare;
			if(start == null) {
				startCompare = 1;
			} else {
				startCompare = d.getDate().compareTo(start);
			}
			
			if(end == null) {
				endCompare = -1;
			} else {
				endCompare = d.getDate().compareTo(end);
			}
			if(startCompare >= 0 && endCompare <= 0) {
				sum += d.getAmount();
			}
		}
		return sum;
	}
	
	public double getExpenses(Date start, Date end) {
		ArrayList<Withdrawal> withdrawals = history.getWithdrawals();
		double sum = 0;
		for(Withdrawal w : withdrawals) {
			int startCompare, endCompare;
			if(start == null) {
				startCompare = 1;
			} else {
				startCompare = w.getDate().compareTo(start);
			}
			if(end == null) {
				endCompare = -1;
			} else {
				endCompare = w.getDate().compareTo(end);
			}
			if(startCompare >= 0 && endCompare <= 0) {
				sum += w.getAmount();
			}
		}
		return sum;
	}
	
}
