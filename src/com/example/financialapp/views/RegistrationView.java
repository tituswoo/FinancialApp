package com.example.financialapp.views;

/**
 * interface used to register users methods should be all the info needed to
 * construct a User.
 * @author Vishal
 * @version 1.0
 */
public interface RegistrationView extends CustomView {
    /**
     * Get the first name input.
     * @return the first name input
     */
    String getFirstName();

    /**
     * Get the last name input.
     * @return the last name input
     */
    String getLastName();

    /**
     * Get the username input.
     * @return the username input
     */
    String getUsername();

    /**
     * Get the password input.
     * @return the password input
     */
    String getPassword();

    /**
     * Get the confirm password input.
     * @return the confirm password input
     */
    String getConfirmPassword();
}
