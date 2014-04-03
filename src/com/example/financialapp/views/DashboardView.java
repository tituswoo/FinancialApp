package com.example.financialapp.views;

import com.example.financialapp.models.User;

/**
 * The interface for the DashboardViewActivity.
 * @author Vishal
 */
public interface DashboardView extends CustomView {
    /**
     * Sets the current user textView.
     * @param user
     *            the user that is currently logged in
     */
    void setCurrentUser(User user);
}
