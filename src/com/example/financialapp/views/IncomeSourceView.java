package com.example.financialapp.views;

import java.util.Date;

/**
 * The interface for the IncomeSourceActivity.
 * @author Vishal
 */
public interface IncomeSourceView extends CustomView {
    /**
     * Sets the date range to be displayed.
     * @param start
     *            the starting date
     * @param end
     *            the ending date
     */
    void setDateRange(Date start, Date end);

    /**
     * Gets the start date input.
     * @return the start date
     */
    Date getStartDate();

    /**
     * Gets the end date input.
     * @return the end date
     */
    Date getEndDate();

    /**
     * Set the salary category amount.
     * @param amount
     *            the amount to be displayed
     */
    void setSalary(double amount);

    /**
     * Set the birthday category amount.
     * @param amount
     *            the amount to be displayed
     */
    void setBirthday(double amount);

    /**
     * Set the parents category amount.
     * @param amount
     *            the amount to be displayed
     */
    void setParents(double amount);

    /**
     * Set the scholarship category amount.
     * @param amount
     *            the amount to be displayed
     */
    void setScholarship(double amount);

    /**
     * Set the other category amount.
     * @param amount
     *            the amount to be displayed
     */
    void setOther(double amount);

    /**
     * Set the total amount.
     * @param amount
     *            the amount to be displayed
     */
    void setTotal(double amount);
}
