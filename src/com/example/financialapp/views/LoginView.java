package com.example.financialapp.views;

/**
 * The interface for interacting with the LoginActivity.
 * 
 * @author Vishal
 */
public interface LoginView extends CustomView {
    /**
     * Get the username input.
     * 
     * @return the username input
     */
    String getUsername();

    /**
     * Get the password input.
     * 
     * @return the password input
     */
    String getPassword();
}
