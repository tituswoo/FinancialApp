package com.example.financialapp.views;

import java.util.Date;

/**
 * The interface for interacting with the WithdrawActivity.
 * @author Vishal
 */
public interface WithdrawView extends CustomView {
    /**
     * Gets the amount input.
     * @return the amount input.
     */
    double getAmount();

    /**
     * Gets the description input.
     * @return the description input
     */
    String getDescription();

    /**
     * Gets the category input.
     * @return the category input
     */
    String getCategory();

    Date getUserDate();

    String getYear();
    
    String getMonth();
    
    String getDay();

    String getUserDateString();
}
