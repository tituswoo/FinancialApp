package com.example.financialapp.views;

import java.util.Date;

/**
 * The interface for the SpendingCategoryActivity.
 * @author Vishal
 */
public interface SpendingCategoryView extends CustomView {
    /**
     * Sets the date range to be displayed.
     * @param start
     *            the starting date
     * @param end
     *            the ending date
     */
    void setDateRange(Date start, Date end);

    /**
     * Get the start date input.
     * @return the end date input
     */
    Date getStartDate();

    /**
     * Get the end date input.
     * @return the end date input
     */
    Date getEndDate();

    /**
     * Set the Food category amount to be displayed.
     * @param amount
     *            the amount to be displayed
     */
    void setFoodExpense(double amount);

    /**
     * Set the Rent category amount to be displayed.
     * @param amount
     *            the amount to be displayed
     */
    void setRentExpense(double amount);

    /**
     * Set the Entertainment category amount to be displayed.
     * @param amount
     *            the amount to be displayed
     */
    void setEntertainmentExpense(double amount);

    /**
     * Set the Clothing category amount to be displayed.
     * @param amount
     *            the amount to be displayed
     */
    void setClothingExpense(double amount);

    /**
     * Set the Other category amount to be displayed.
     * @param amount
     *            the amount to be displayed
     */
    void setOtherExpense(double amount);

    /**
     * Set the Total category amount to be displayed.
     * @param amount
     *            the amount to be displayed
     */
    void setTotalExpense(double amount);
}
