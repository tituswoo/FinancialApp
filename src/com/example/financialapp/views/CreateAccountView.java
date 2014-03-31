package com.example.financialapp.views;

/**
 * The interface for the CreateAccountActivity.
 * 
 * @author Vishal
 */
public interface CreateAccountView extends CustomView {
    /**
     * gets the AccountName from the EditText.
     * @return the account name
     */
    String getAccountName();
}
