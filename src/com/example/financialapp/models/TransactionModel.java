package com.example.financialapp.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The TransactionModel interface allows for different implementations.
 * @author Vishal
 */
public interface TransactionModel {
    /**
     * Add a transaction to the transaction history.
     * @param t the transaction to be added
     */
    void add(Transaction t);

    /**
     * Undoes the most recent transaction.
     * @return the Transaction that was undone by this action
     */
    Transaction undoTransaction();

    /**
     * Gets a list of the transactions.
     * @return an array list containing the transaction history
     */
    ArrayList<Transaction> getTransactionHistory();

    /**
     * The list of all deposits.
     * @return a list of all deposits
     */
    ArrayList<Deposit> getDeposits();

    /**
     * The list of all withdrawals.
     * @return a list of all withdrawals
     */
    ArrayList<Withdrawal> getWithdrawals();

    /**
     * get the total balance of the account.
     * @return the balance of the account
     */
    double getBalance();

    /**
     * gets all transactions of a certain category.
     * @param category the category of transactions
     * @return a list of transactions that fall into the specified category
     */
    ArrayList<Transaction> getCategory(String category);

    List<Transaction> getTransactionHistory(Date startDate, Date endDate);

    double getBalance(Date startDate, Date endDate);
}
