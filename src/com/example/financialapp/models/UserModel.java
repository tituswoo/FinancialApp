package com.example.financialapp.models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Vishal
 * The class that handles all users.
 */
public final class UserModel {
    /**
     * The Map that stores all users.
     */
    private static Map<String, User> users;
    /**
     * The current user that is logged in.
     */
    private static User current;
    /**
     * The initial capacity of the HashMap.
     */
    private static final int INITIAL_CAPACITY = 10;

    static {
        users = new HashMap<String, User>(INITIAL_CAPACITY);
        users.put("admin", new Admin("admin", "John", "Doe", "pass1234"));
        users.put("", new User("", "Vish", "All", ""));
        current = null;
    }
    /**
     * private Constructor to avoid generating a default public constructor.
     */
    private UserModel() {
        //do nothing
    }
    /**
     * Return true if the username exists in the user base.
     * @param username the username to be checked
     * @return true if the username exists in the user base
     */
    public static boolean usernameExists(String username) {
        return users.get(username) != null;
    }

    /**
     * @param newUser
     *            - the new user to be added to the user list
     * @return true if the user was successfully added, false if the user cannot
     *         be added
     */
    public static boolean addUser(User newUser) {

        if (!usernameExists(newUser.getUsername())) {
            users.put(newUser.getUsername(), newUser);
        }

        return usernameExists(newUser.getUsername());
    }

    /**
     * Logs the user into the usermodel.
     * @param username the username of the user
     * @param password the password of the user
     * @return true if successful login
     */
    public static boolean login(String username, String password) {
        if (usernameExists(username)) {
            User user = users.get(username);
            current = user;
            return user.getPassword().equals(password);
        }
        return false;
    }

    /**
     * Returns the current user.
     * @return the current user
     */
    public static User getCurrentUser() {
        return current;
    }

    /**
     * Returns the income from one date to the next. Null for either value
     * represents the most extreme date in that direction
     * @param start
     *            the starting date
     * @param end
     *            the ending data
     * @return the income
     */
    public static double getIncome(Date start, Date end) {
        return current.getIncome(start, end);
    }

    /**
     * Returns the expenses from one date to the next. Null for either value
     * represents the most extreme date in that direction
     * @param start
     *            the starting date
     * @param end
     *            the ending data
     * @return the expenses
     */
    public static double getExpenses(Date start, Date end) {
        return current.getExpenses(start, end);
    }
    /**
     * Returns the expenses of the appropriate category.
     * @param start the starting date
     * @param end the ending date
     * @return the expenses of the approprate category
     */
    public static double getFoodExpense(Date start, Date end) {
        return current.getFoodExpense(start, end);
    }
    /**
     * Returns the expenses of the appropriate category.
     * @param start the starting date
     * @param end the ending date
     * @return the expenses of the approprate category
     */
    public static double getRentExpense(Date start, Date end) {
        return current.getRentExpense(start, end);
    }
    /**
     * Returns the expenses of the appropriate category.
     * @param start the starting date
     * @param end the ending date
     * @return the expenses of the approprate category
     */
    public static double getEntertainmentExpense(Date start, Date end) {
        return current.getEntertainmentExpense(start, end);
    }
    /**
     * Returns the expenses of the appropriate category.
     * @param start the starting date
     * @param end the ending date
     * @return the expenses of the approprate category
     */
    public static double getClothingExpense(Date start, Date end) {
        return current.getClothingExpense(start, end);
    }
    /**
     * Returns the expenses of the appropriate category.
     * @param start the starting date
     * @param end the ending date
     * @return the expenses of the approprate category
     */
    public static double getOtherExpense(Date start, Date end) {
        return current.getOtherExpense(start, end);
    }
    /**
     * Returns the expenses of the appropriate category.
     * @param start the starting date
     * @param end the ending date
     * @return the expenses of the appropriate category
     */
    public static double getTotalExpense(Date start, Date end) {
        return current.getTotalExpense(start, end);
    }
    /**
     * Get the income of a certain category.
     * @param category the category specified
     * @param start the start date
     * @param end the end date
     * @return the sum of all deposits in this category
     */
    public static double getIncomeSource(String category, Date start,
            Date end) {
        return current.getIncomeSource(category, start, end);
    }

}
