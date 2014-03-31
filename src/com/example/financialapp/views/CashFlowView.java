package com.example.financialapp.views;

import java.util.Date;

/**
 * interface for CashFlowViewActivity.
 * 
 * @author Vishal
 */
public interface CashFlowView extends CustomView {
    /**
     * Sets the date range text view.
     * 
     * @param start
     *            the starting date
     * @param end
     *            the ending date
     */
    void setDateRange(Date start, Date end);

    /**
     * Gets the start date of the DatePicker.
     * 
     * @return the start date of the DatePicker
     */
    Date getStartDate();

    /**
     * Gets the end date of the DatePicker.
     * 
     * @return the end date of the DatePicker
     */
    Date getEndDate();

    /**
     * Sets the Income textView.
     * 
     * @param amount
     *            the amount to be displayed
     */
    void setIncome(double amount);

    /**
     * Sets the Expenses textView.
     * 
     * @param amount
     *            the amount to be displayed
     */
    void setExpenses(double amount);

    /**
     * Sets the Flow textView.
     * 
     * @param amount
     *            the amount to be displayed
     */
    void setFlow(double amount);
}
