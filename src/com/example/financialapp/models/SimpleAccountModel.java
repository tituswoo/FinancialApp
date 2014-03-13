package com.example.financialapp.models;

import java.util.ArrayList;
import java.util.Date;

public class SimpleAccountModel implements AccountModel {
	private ArrayList<Account> accounts;
	private Account current;
	
	public SimpleAccountModel() {
		accounts = new ArrayList<Account>();
		current = null;
	}
	@Override
	public void addAccount(User user, Account account) {
		accounts.add(account);
	}
	@Override
	public ArrayList<Account> getAccounts(User user) {
		return accounts;
	}
	@Override
	public Account getCurrentAccount() {
		return current;
	}
	@Override
	public void setCurrentAccount(Account account) {
		this.current = account;
	}
	@Override
	public double getIncome(User u, Date start, Date end) {
		double sum = 0;
		for(Account a : accounts) {
			sum += a.getIncome(start, end);
		}
		return sum;
	}
	@Override
	public double getExpenses(User u, Date start, Date end) {
		double sum = 0;
		for(Account a : accounts) {
			sum += a.getExpenses(start, end);
		}
		return sum;
	}
	
}