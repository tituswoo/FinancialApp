package com.example.financialapp.views;

/**
 * AccountView for accessing AccountViewActivity.
 * @author Vishal
 */
public interface AccountView extends CustomView {
    /**
     * Sets the balance.
     * @param balance
     *            the amount to be displayed
     */
    void setBalance(double balance);

    /**
     * Updates the account name.
     */
    void setAccountName();
}

