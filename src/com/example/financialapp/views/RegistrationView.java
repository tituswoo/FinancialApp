package com.example.financialapp.views;

/**
 * interface used to register users methods should be all the info needed to
 * construct a User
 * 
 * @author Vishal
 * @version 1.0
 */
public interface RegistrationView extends CustomView {
    public String getFirstName();

    public String getLastName();

    public String getUsername();

    public String getPassword();

    public String getConfirmPassword();
}
