package com.example.financialapp.models;

import java.util.ArrayList;
import java.util.Date;

/**
 * A public interface for the account model.
 * This allows for different implementations.
 * @author Vishal
 */
public interface AccountModel {
    /**
     * Gets a list of accounts owned by a particular user.
     * @param user the user we would like an account list for
     * @return a list of u's accounts
     */
    ArrayList<Account> getAccounts(User user);

    /**
     * adds an account to a particular user.
     * @param user the user we would like to add an account to
     * @param account the account to be added
     */
    void addAccount(User user, Account account);

    /**
     * Gets the current account that the user should be viewing.
     * @return the account the user should be viewing
     */
    Account getCurrentAccount();

    /**
     * sets the current account that the user should be viewing.
     * @param account the account the user should be viewing
     */
    void setCurrentAccount(Account account);
    /**
     * Gets the appropriate category.
     * @param u the user
     * @param start the start date
     * @param end the end date
     * @return the value
     */
    double getIncome(User u, Date start, Date end);
    /**
     * Gets the appropriate category.
     * @param u the user
     * @param start the start date
     * @param end the end date
     * @return the value
     */
    double getExpenses(User u, Date start, Date end);
    /**
     * Gets the appropriate category.
     * @param u the user
     * @param start the start date
     * @param end the end date
     * @return the value
     */
    double getFoodExpense(User u, Date start, Date end);
    /**
     * Gets the appropriate category.
     * @param u the user
     * @param start the start date
     * @param end the end date
     * @return the value
     */
    double getRentExpense(User u, Date start, Date end);
    /**
     * Gets the appropriate category.
     * @param u the user
     * @param start the start date
     * @param end the end date
     * @return the value
     */
    double getEntertainmentExpense(User u, Date start, Date end);
    /**
     * Gets the appropriate category.
     * @param u the user
     * @param start the start date
     * @param end the end date
     * @return the value
     */
    double getClothingExpense(User u, Date start, Date end);
    /**
     * Gets the appropriate category.
     * @param u the user
     * @param start the start date
     * @param end the end date
     * @return the value
     */
    double getOtherExpense(User u, Date start, Date end);
    /**
     * Gets the appropriate category.
     * @param u the user
     * @param start the start date
     * @param end the end date
     * @return the value
     */
    double getTotalExpense(User u, Date start, Date end);
    /**
     * Gets the appropriate category.
     * @param user the user
     * @param category the category
     * @param start the start date
     * @param end the end date
     * @return the value
     */
    double getIncomeSource(User user, String category, Date start,
            Date end);
}
