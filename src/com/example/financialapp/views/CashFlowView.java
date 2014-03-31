package com.example.financialapp.views;

import java.util.Date;

/**
 * CashFlowView
 * 
 * @author Vishal
 * 
 */
public interface CashFlowView extends CustomView {
    /**
     * setDateRange
     * 
     * @param start
     * @param end
     */
    public void setDateRange(Date start, Date end);

    public Date getStartDate();

    public Date getEndDate();

    public void setIncome(double amount);

    public void setExpenses(double amount);

    public void setFlow(double amount);
}
