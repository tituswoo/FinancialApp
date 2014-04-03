package com.example.financialapp.models;

import java.util.ArrayList;
import java.util.Date;
/**
 * @author Vishal
 * This class models a financial account.
 */
public class Account {
    /**
     * the transaction history.
     */
    private TransactionModel history;
    /**
     * The name of the account.
     */
    private String name;
    /**
     * Constructs an account.
     * @param n the name of the account
     */
    public Account(String n) {
        history = new SimpleTransactionModel();
        this.name = n;
    }
    /**
     * Returns the name.
     * @return the name
     */
    public String getName() {
        return this.name;
    }
    /**
     * Adds a transaction to the transaction history.
     * @param t The transaction to be added
     */
    public void add(Transaction t) {
        history.add(t);
    }
    /**
     * Returns the balance.
     * @return the balance
     */
    public double getBalance() {
        return history.getBalance();
    }
    /**
     * Get the deposits from start date to end date.
     * @param start date
     * @param end date
     * @return the list of deposits
     */
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
    /**
     * Gets the appropriate category.
     * @param start the start date
     * @param end the end date
     * @return the value
     */
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
    /**
     * Gets the appropriate category.
     * @param start the start date
     * @param end the end date
     * @return the value
     */
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
    /**
     * Gets the appropriate category.
     * @param start the start date
     * @param end the end date
     * @return the value
     */
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
    /**
     * Gets the appropriate category.
     * @param start the start date
     * @param end the end date
     * @return the value
     */
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
    /**
     * Gets the appropriate category.
     * @param start the start date
     * @param end the end date
     * @return the value
     */
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
    /**
     * Gets the appropriate category.
     * @param start the start date
     * @param end the end date
     * @return the value
     */
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
    /**
     * Gets the appropriate category.
     * @param start the start date
     * @param end the end date
     * @return the value
     */
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
    /**
     * Gets the appropriate category.
     * @param start the start date
     * @param end the end date
     * @return the value
     */
    public double getTotalExpense(Date start, Date end) {
        double food = getFoodExpense(start, end);
        double rent = getRentExpense(start, end);
        double entertainment = getEntertainmentExpense(start, end);
        double clothing = getClothingExpense(start, end);
        double other = getOtherExpense(start, end);
        return food + rent + entertainment + clothing + other;
    }

}
