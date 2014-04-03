package com.example.financialapp.models;

/**
 * @author Vishal
 * Represents transactions that are specifically withdrawals.
 */
public class Withdrawal extends Transaction {
    /**
     * Constructs a withdrawal.
     * @param amount the amount
     * @param description the description
     * @param category the category
     */
    public Withdrawal(double amount, String description, String category) {
        super(-amount, description, category);
    }
}
