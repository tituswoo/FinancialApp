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
    private Date userDate;
    private String userDateString;
    private String type;
    private String status;
    private double rollback;
    /**
     * Constructs a transaction.
     * @param a - the amount
     * @param d - the date
     * @param c - the category
     */
    public Transaction(double a, String d, String c, Date userDate, String userDateString, String type, String status) {
        this.amount = a;
        this.description = d;
        this.category = c;
        this.userDate = userDate;
        this.userDateString = userDateString;
        this.type = type;
        this.status = status;
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
    
    public Date getUserDate() {
        return userDate;
    }
    
    public void setUserDate(Date d) {
        this.userDate = d;
    }
    
    public String getUserDateString() {
        return userDateString;
    }
    
    public void setUserDateString(String userDateString) {
        this.userDateString = userDateString;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type=type;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status=status;
    }
    
    public double getRollback() {
        return rollback;
    }
    
    public void setRollback(Double rollback) {
        this.rollback=rollback;
    }
    
    
    /**
     * Sets the date.
     * @param d date
     */
    public void setDate(Date d) {
        this.date = d;
    }
}
