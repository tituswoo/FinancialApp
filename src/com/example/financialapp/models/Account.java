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

	public ArrayList<Deposit> getDeposits(Date start, Date end) {
		ArrayList<Deposit> deposits = history.getDeposits();
		ArrayList<Deposit> dateDeposits = new ArrayList<Deposit>();
		for (Deposit d : deposits) {
			int startCompare, endCompare;
			if (start == null) {
				startCompare = 1;
			} else {
				startCompare = d.getDate().compareTo(start);
			}

			if (end == null) {
				endCompare = -1;
			} else {
				endCompare = d.getDate().compareTo(end);
			}
			if (startCompare >= 0 && endCompare <= 0) {
				dateDeposits.add(d);
			}
		}
		return dateDeposits;
	}

	public double getIncome(Date start, Date end) {
		ArrayList<Deposit> deposits = history.getDeposits();
		double sum = 0;
		for (Deposit d : deposits) {
			int startCompare, endCompare;
			if (start == null) {
				startCompare = 1;
			} else {
				startCompare = d.getDate().compareTo(start);
			}

			if (end == null) {
				endCompare = -1;
			} else {
				endCompare = d.getDate().compareTo(end);
			}
			if (startCompare >= 0 && endCompare <= 0) {
				sum += d.getAmount();
			}
		}
		return sum;
	}

	public double getExpenses(Date start, Date end) {
		ArrayList<Withdrawal> withdrawals = history.getWithdrawals();
		double sum = 0;
		for (Withdrawal w : withdrawals) {
			int startCompare, endCompare;
			if (start == null) {
				startCompare = 1;
			} else {
				startCompare = w.getDate().compareTo(start);
			}
			if (end == null) {
				endCompare = -1;
			} else {
				endCompare = w.getDate().compareTo(end);
			}
			if (startCompare >= 0 && endCompare <= 0) {
				sum += w.getAmount();
			}
		}
		return sum;
	}

	public double getFoodExpense(Date start, Date end) {
		ArrayList<Withdrawal> withdrawals = history.getWithdrawals();
		double sum = 0;
		for (Withdrawal w : withdrawals) {
			int startCompare, endCompare;
			if (start == null) {
				startCompare = 1;
			} else {
				startCompare = w.getDate().compareTo(start);
			}
			if (end == null) {
				endCompare = -1;
			} else {
				endCompare = w.getDate().compareTo(end);
			}
			if (startCompare >= 0 && endCompare <= 0
					&& w.getCategory().equals("Food")) {
				sum += w.getAmount();
			}
		}
		return sum;
	}

	public double getRentExpense(Date start, Date end) {
		ArrayList<Withdrawal> withdrawals = history.getWithdrawals();
		double sum = 0;
		for (Withdrawal w : withdrawals) {
			int startCompare, endCompare;
			if (start == null) {
				startCompare = 1;
			} else {
				startCompare = w.getDate().compareTo(start);
			}
			if (end == null) {
				endCompare = -1;
			} else {
				endCompare = w.getDate().compareTo(end);
			}
			if (startCompare >= 0 && endCompare <= 0
					&& w.getCategory().equals("Rent/Expenses")) {
				sum += w.getAmount();
			}
		}
		return sum;
	}

	public double getEntertainmentExpense(Date start, Date end) {
		ArrayList<Withdrawal> withdrawals = history.getWithdrawals();
		double sum = 0;
		for (Withdrawal w : withdrawals) {
			int startCompare, endCompare;
			if (start == null) {
				startCompare = 1;
			} else {
				startCompare = w.getDate().compareTo(start);
			}
			if (end == null) {
				endCompare = -1;
			} else {
				endCompare = w.getDate().compareTo(end);
			}
			if (startCompare >= 0 && endCompare <= 0
					&& w.getCategory().equals("Expenses")) {
				sum += w.getAmount();
			}
		}
		return sum;
	}

	public double getClothingExpense(Date start, Date end) {
		ArrayList<Withdrawal> withdrawals = history.getWithdrawals();
		double sum = 0;
		for (Withdrawal w : withdrawals) {
			int startCompare, endCompare;
			if (start == null) {
				startCompare = 1;
			} else {
				startCompare = w.getDate().compareTo(start);
			}
			if (end == null) {
				endCompare = -1;
			} else {
				endCompare = w.getDate().compareTo(end);
			}
			if (startCompare >= 0 && endCompare <= 0
					&& w.getCategory().equals("Clothing")) {
				sum += w.getAmount();
			}
		}
		return sum;
	}

	public double getOtherExpense(Date start, Date end) {
		ArrayList<Withdrawal> withdrawals = history.getWithdrawals();
		double sum = 0;
		for (Withdrawal w : withdrawals) {
			int startCompare, endCompare;
			if (start == null) {
				startCompare = 1;
			} else {
				startCompare = w.getDate().compareTo(start);
			}
			if (end == null) {
				endCompare = -1;
			} else {
				endCompare = w.getDate().compareTo(end);
			}
			if (startCompare >= 0 && endCompare <= 0
					&& w.getCategory().equals("Other")) {
				sum += w.getAmount();
			}
		}
		return sum;
	}

	public double getTotalExpense(Date start, Date end) {
		double food = getFoodExpense(start, end);
		double rent = getRentExpense(start, end);
		double entertainment = getEntertainmentExpense(start, end);
		double clothing = getClothingExpense(start, end);
		double other = getOtherExpense(start, end);
		return food + rent + entertainment + clothing + other;
	}

}
