package com.example.financialapp.views;

/**
 * AccountView interface for accesssing AccountActivity
 * 
 * @author Vishal
 * 
 */
public interface AccountView extends CustomView {
    /**
     * Sets the balance
     * 
     * @param balance
     */
    void setBalance(double balance);

    /**
     * Updates the account name
     */
    void setAccountName();
}
