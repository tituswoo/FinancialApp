package com.example.financialapp.views;

/**
 * The interface for interacting with the WithdrawActivity
 * 
 * @author Vishal
 */
public interface WithdrawView extends CustomView {
    /**
     * Gets the amount input.
     * 
     * @return the amount input.
     */
    double getAmount();

    /**
     * Gets the description input.
     * 
     * @return the description input
     */
    String getDescription();

    /**
     * Gets the category input.
     * 
     * @return the category input
     */
    String getCategory();
}
