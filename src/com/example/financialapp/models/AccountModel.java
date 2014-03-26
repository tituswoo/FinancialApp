package com.example.financialapp.models;

import java.util.ArrayList;
import java.util.Date;

public interface AccountModel {
	/**
	 * Gets a list of accounts owned by a particular user
	 * 
	 * @param user
	 *            the user we would like an account list for
	 * @return a list of u's accounts
	 */
	public ArrayList<Account> getAccounts(User user);

	/**
	 * adds an account to a particular user
	 * 
	 * @param user
	 *            the user we would like to add an account to
	 * @param account
	 *            the account to be added
	 */
	public void addAccount(User user, Account account);

	/**
	 * Gets the current account that the user should be viewing
	 * 
	 * @param user
	 *            the user for which to get the current account
	 * @return the account the user should be viewing
	 */
	public Account getCurrentAccount();

	/**
	 * sets the current account that the user should be viewing
	 * 
	 * @param account
	 *            the account the user should be viewing
	 */
	public void setCurrentAccount(Account account);

	public double getIncome(User u, Date start, Date end);

	public double getExpenses(User u, Date start, Date end);
}
