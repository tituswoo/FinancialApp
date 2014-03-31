package com.example.financialapp.views;

import android.view.View;

/**
 * This interface ensures that presenters can do stuff when their views report a
 * tap/click event.
 * @author Titus Woo
 */
public interface ClickListener {
    /**
     * Respond to button click.
     *
     * @param v
     *            the button that was clicked
     */
    void onClick(View v);
}
