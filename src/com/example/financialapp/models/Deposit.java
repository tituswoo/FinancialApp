package com.example.financialapp.models;

/**
 * @author Vishal
 * This class represents Transactions that are specifically Deposits.
 */
public class Deposit extends Transaction {
    /**
     * Constructs a Deposit.
     * @param amount the amount of the deposit
     * @param description the description of deposit
     * @param category the category of the deposit
     */
    public Deposit(double amount, String description, String category) {
        super(amount, description, category);
    }
}
