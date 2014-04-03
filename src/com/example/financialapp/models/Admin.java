package com.example.financialapp.models;

/**
 * @author Vishal
 * The class for users with admin privileges
 */
public class Admin extends User {
    /**
     * constructs and admin.
     * @param username the admins username
     */
    public Admin(String username) {
        super(username);
    }
    /**
     * Construcst and admin.
     * @param username the username
     * @param first the first name
     * @param last the last name
     * @param password the password
     */
    public Admin(String username, String first, String last, String password) {
        super(username, first, last, password);
    }
}
