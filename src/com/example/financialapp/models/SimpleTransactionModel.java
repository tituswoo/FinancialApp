package com.example.financialapp.models;

import java.util.ArrayList;

public class SimpleTransactionModel implements TransactionModel {
	
	ArrayList<Transaction> history;
	
	public SimpleTransactionModel() {
		history = new ArrayList<Transaction>();
	}
	@Override
	public void addTransaction(Transaction t) {
		history.add(t);
	}

	@Override
	public Transaction undoTransaction() {
		return history.remove(history.size() - 1);
	}

	@Override
	public ArrayList<Transaction> getTransactionHistory() {
		return history;
	}
	
	public ArrayList<Deposit> getDeposits() {
		ArrayList<Deposit> deposits = new ArrayList<Deposit>();
		for(Transaction t : history) {
			if(t instanceof Deposit) {
				deposits.add((Deposit) t);
			}
		}
		return deposits;
	}
	
	public ArrayList<Withdrawal> getWithdrawals() {
		ArrayList<Withdrawal> withdrawals = new ArrayList<Withdrawal>();
		for(Transaction t : history) {
			if(t instanceof Withdrawal) {
				withdrawals.add((Withdrawal) t);
			}
		}
		return withdrawals;
	}
}
