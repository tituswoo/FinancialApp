package com.example.financialapp.views;

import java.util.Date;

/**
 * The interface for the DepositViewActivity.
 * @author Vishal
 */
public interface DepositView extends CustomView {
    /**
     * gets the Amount from the editText to be entered.
     * @return the amount
     */
    double getAmount();

    /**
     * gets the description entered .
     * @return the description of the Transaction
     */
    String getDescription();

    /**
     * gets the Category entered.
     * @return the category
     */
    String getCategory();
    
    Date getUserDate();

    String getYear();
    
    String getMonth();
    
    String getDay();

    String getUserDateString();
}
