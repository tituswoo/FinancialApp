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
	
	public double getIncomeSource(User u, String category, Date start, Date end) {
		double sum = 0;
		ArrayList<Deposit> deposit = new ArrayList<Deposit>();
		for (Account a : accounts) {
			deposit = a.getDeposits(start, end);
			for (Deposit d : deposit) {
				if (d.getCategory().compareTo(category)==0) {
					sum += d.getAmount();
				}
			}
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
	@Override
	public double getFoodExpense(User u, Date start, Date end) {
		double sum = 0;
		for(Account a : accounts) {
			sum += a.getFoodExpense(start, end);
		}
		return sum;
	}
	@Override
	public double getRentExpense(User u, Date start, Date end) {
		double sum = 0;
		for(Account a : accounts) {
			sum += a.getRentExpense(start, end);
		}
		return sum;
	}
	@Override
	public double getEntertainmentExpense(User u, Date start, Date end) {
		double sum = 0;
		for(Account a : accounts) {
			sum += a.getEntertainmentExpense(start, end);
		}
		return sum;
	}
	@Override
	public double getClothingExpense(User u, Date start, Date end) {
		double sum = 0;
		for(Account a : accounts) {
			sum += a.getClothingExpense(start, end);
		}
		return sum;
	}
	@Override
	public double getOtherExpense(User u, Date start, Date end) {
		double sum = 0;
		for(Account a : accounts) {
			sum += a.getOtherExpense(start, end);
		}
		return sum;
	}
	@Override
	public double getTotalExpense(User u, Date start, Date end) {
		double sum = 0;
		for(Account a : accounts) {
			sum += a.getTotalExpense(start, end);
		}
		return sum;
	}
	
}
