package com.example.financialapp.models;
import java.util.ArrayList;

public interface TransactionModel {
	/**
	 * Add a transaction to the transaction history
	 * @param t the transaction to be added
	 */
	public void addTransaction(Transaction t);
	
	/**
	 * Undoes the most recent transaction
	 * @return the Transaction that was undone by this action
	 */
	public Transaction undoTransaction();
	
	/**
	 * Gets a list of the transactions
	 * @return an array list containing the transaction history
	 */
	public ArrayList<Transaction> getTransactionHistory();
	
	/**
	 * The list of all deposits
	 * @return a list of all deposits
	 */
	public ArrayList<Deposit> getDeposits();
	
	/**
	 * The list of all withdrawals
	 * @return a list of all withdrawals
	 */
	public ArrayList<Withdrawal> getWithdrawals();
	
	
}
