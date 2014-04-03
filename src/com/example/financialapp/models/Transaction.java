package com.example.financialapp.models;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Vishal
 * used to represent transactions.
 */
public class Transaction {
    /**
     * Short description of the transaction.
     */
    private String description;
    /**
     * category of the transaction.
     */
    private String category;
    /**
     * amount the transaction is worth.
     */
    private double amount;
    /**
     * The date the transaction occurred on.
     */
    private Date date;
    /**
     * Constructs a transaction.
     * @param a - the amount
     * @param d - the date
     * @param c - the category
     */
    public Transaction(double a, String d, String c) {
        this.amount = a;
        this.description = d;
        this.category = c;
        date = Calendar.getInstance().getTime();
    }
    /**
     * Returns the category.
     * @return the category
     */
    public String getCategory() {
        return category;
    }
    /**
     * Sets the category.
     * @param c category
     */
    public void setCategory(String c) {
        this.category = c;
    }
    /**
     * Returns the description.
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the description.
     * @param d description
     */
    public void setDescription(String d) {
        this.description = d;
    }
    /**
     * Returns the amount.
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount.
     * @param a amount
     */
    public void setAmount(double a) {
        this.amount = a;
    }
    /**
     * Returns the date.
     * @return the date
     */
    public Date getDate() {
        return date;
    }
    /**
     * Sets the date.
     * @param d date
     */
    public void setDate(Date d) {
        this.date = d;
    }
}
