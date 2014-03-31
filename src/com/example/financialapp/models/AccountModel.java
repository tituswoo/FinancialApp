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

    double getIncome(User u, Date start, Date end);

    double getExpenses(User u, Date start, Date end);

    double getFoodExpense(User u, Date start, Date end);

    double getRentExpense(User u, Date start, Date end);

    double getEntertainmentExpense(User u, Date start, Date end);

    double getClothingExpense(User u, Date start, Date end);

    double getOtherExpense(User u, Date start, Date end);

    double getTotalExpense(User u, Date start, Date end);

    double getIncomeSource(User user, String category, Date start,
            Date end);
}
