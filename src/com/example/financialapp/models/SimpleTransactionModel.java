package com.example.financialapp.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Vishal
 * An implementation of the TransactionModel interface.
 */
public class SimpleTransactionModel implements TransactionModel {
    /**
     * Keeps track of all transaction.
     */
    private ArrayList<Transaction> history;
    /**
     * Constructs a transaction model.
     */
    public SimpleTransactionModel() {
        history = new ArrayList<Transaction>();
    }

    @Override
    public void add(Transaction t) {
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
    @Override
    public ArrayList<Deposit> getDeposits() {
        ArrayList<Deposit> deposits = new ArrayList<Deposit>();
        for (Transaction t : history) {
            if (t instanceof Deposit) {
                deposits.add((Deposit) t);
            }
        }
        return deposits;
    }
    @Override
    public ArrayList<Withdrawal> getWithdrawals() {
        ArrayList<Withdrawal> withdrawals = new ArrayList<Withdrawal>();
        for (Transaction t : history) {
            if (t instanceof Withdrawal) {
                withdrawals.add((Withdrawal) t);
            }
        }
        return withdrawals;
    }

    @Override
    public double getBalance() {
        double balance = 0;
        for (Transaction t : history) {
            balance += t.getAmount();
        }
        return balance;
    }

    @Override
    public ArrayList<Transaction> getCategory(String category) {
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        for (Transaction t : history) {
            if (t.getCategory().equals(category)) {
                list.add(t);
            }
        }
        return list;
    }

    @Override
    public List<Transaction> getTransactionHistory(Date startDate, Date endDate) {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        for (Transaction t : history) {
            int startCompare, endCompare;
            if (startDate == null) {
                startCompare = 1;
            } else {
                startCompare = t.getUserDate().compareTo(startDate);
            }
    
            if (endDate == null) {
                endCompare = -1;
            } else {
                endCompare = t.getUserDate().compareTo(endDate);
            }
            if (startCompare >= 0 && endCompare <= 0) {
                transactions.add(t);
            }
        }
        return transactions;
    }

    @Override
    public double getBalance(Date startDate, Date endDate) {
        double balance = 0;
        for (Transaction t : history) {
            int startCompare, endCompare;
            if (startDate == null) {
                startCompare = 1;
            } else {
                startCompare = t.getUserDate().compareTo(startDate);
            }
    
            if (endDate == null) {
                endCompare = -1;
            } else {
                endCompare = t.getUserDate().compareTo(endDate);
            }
            if (startCompare >= 0 && endCompare <= 0) {
                balance += t.getAmount();
            }
        }
        return balance;
    }
}
