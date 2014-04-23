package com.example.financialapp.models;

import java.util.Date;

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
    public Withdrawal(double amount, String description, String category, Date userDate, String userDateString, String type, String status) {
        super(-amount, description, category, userDate, userDateString, type, status);
    }
}
