package com.example.financialapp.models;

import java.util.Date;

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
    public Deposit(double amount, String description, String category, Date userDate, String userDateString, String type, String status) {
        super(amount, description, category, userDate, userDateString, type, status);
    }
}
