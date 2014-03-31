package com.example.financialapp.views;

import android.view.View;

/**
 * This provides base functionality for our custom views.
 * @author Titus Woo
 */
public interface CustomView {
    /**
     * This is the hook that grants the ViewPresenter access to the view. In
     * other words, this lets the view communicate with the ViewPresenter.
     * @param listener
     *            the presenter to be linked
     */
    void linkNotifyCallback(ClickListener listener);

    /**
     * To be called by Button xml android:onClick attribute.
     * @param v the button pressed
     */
    void onBtnClick(View v);
}
