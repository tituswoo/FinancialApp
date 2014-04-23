package com.example.financialapp.views;

import java.util.Date;

/**
 * Interface for interacting with UI elements.
 * @author Vishal
 */
public interface DateSetterView extends CustomView {
    Date getStartDate();
    Date getEndDate();
}
