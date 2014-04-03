package com.example.financialapp.models;

import java.util.Date;

/**
 * Represents the user and all of its data.
 * @author Vishal
 */
public class User {
    /**
     * First name of the user.
     */
    private String firstName;
    /**
     * Last name of the user.
     */
    private String lastName;
    /**
     * User name of the user.
     */
    private String username;
    /**
     * password of the user.
     */
    private String password;
    /**
     * The accounts the user possesses.
     */
    private AccountModel accounts;

    /**
     * Constructs a user with default parameters.
     */
    public User() {
        this("admin", "John", "Doe", "1234");
    }
    /**
     * Constructs a user.
     * @param u the username
     * @param pass the password
     */
    public User(String u, String pass) {
        this(u, "John", "Doe", pass);
    }
    /**
     * Constructs a user.
     * @param u username
     */
    public User(String u) {
        this(u, "firstName", "lastName", "1234");
    }
    /**
     * Constructs a user with all explicit attributes.
     * @param user the username
     * @param first the user's first name
     * @param last the user's last name
     * @param pass the user's password
     */
    public User(String user, String first, String last,
            String pass) {
        this.username = user.trim();
        this.firstName = first.trim();
        this.lastName = last.trim();
        this.password = pass;
        accounts = new SimpleAccountModel();
    }
    /**
     * Gets the income in the date range.
     * @param start the start date of the date range
     * @param end the end date of the date range
     * @return the income in the date range
     */
    public double getIncome(Date start, Date end) {
        return accounts.getIncome(this, start, end);
    }
    /**
     * Gets the income of a certain category.
     * @param category the category specified
     * @param start the start date
     * @param end the end date
     * @return the income of a certain category
     */
    public double getIncomeSource(String category, Date start, Date end) {
        return accounts.getIncomeSource(this, category, start, end);
    }
    /**
     * Gets the expenses.
     * @param start the start date
     * @param end the end date
     * @return the sume of the expenses
     */
    public double getExpenses(Date start, Date end) {
        return accounts.getExpenses(this, start, end);
    }
    /**
     * Gets the expenses of the appropriate category.
     * @param start the start date
     * @param end the end date
     * @return the expenses of the appropriate category
     */
    public double getFoodExpense(Date start, Date end) {
        return accounts.getFoodExpense(this, start, end);
    }
    /**
     * Gets the expenses of the appropriate category.
     * @param start the start date
     * @param end the end date
     * @return the expenses of the appropriate category
     */
    public double getRentExpense(Date start, Date end) {
        return accounts.getRentExpense(this, start, end);
    }
    /**
     * Gets the expenses of the appropriate category.
     * @param start the start date
     * @param end the end date
     * @return the expenses of the appropriate category
     */
    public double getEntertainmentExpense(Date start, Date end) {
        return accounts.getEntertainmentExpense(this, start, end);
    }
    /**
     * Gets the expenses of the appropriate category.
     * @param start the start date
     * @param end the end date
     * @return the expenses of the appropriate category
     */
    public double getClothingExpense(Date start, Date end) {
        return accounts.getClothingExpense(this, start, end);
    }
    /**
     * Gets the expenses of the appropriate category.
     * @param start the start date
     * @param end the end date
     * @return the expenses of the appropriate category
     */
    public double getOtherExpense(Date start, Date end) {
        return accounts.getOtherExpense(this, start, end);
    }
    /**
     * Gets the expenses of the appropriate category.
     * @param start the start date
     * @param end the end date
     * @return the expenses of the appropriate category
     */
    public double getTotalExpense(Date start, Date end) {
        return accounts.getTotalExpense(this, start, end);
    }
    /**
     * Returns the account model.
     * @return the account model
     */
    public AccountModel getAccountModel() {
        return accounts;
    }
    /**
     * Returns a String representation of User.
     * @return a string representation of User
     */
    public String toString() {
        return username + "(" + firstName + " " + lastName + ")";
    }
    /**
     * Returns the first name.
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Sets the first name.
     * @param f first name
     */
    public void setFirstName(String f) {
        firstName = f;
    }
    /**
     * Returns the last name.
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Sets the last name.
     * @param l the last name
     */
    public void setLastName(String l) {
        lastName = l;
    }
    /**
     * Sets the password.
     * @param newPswd the password to be set
     */
    public void setPassword(String newPswd) {
        password = newPswd;
    }
    /**
     * Returns the user's password.
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Returns the username.
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    /**
     * Sets the username.
     * @param newUsername the username
     */
    public void setUsername(String newUsername) {
        username = newUsername;
    }
}
