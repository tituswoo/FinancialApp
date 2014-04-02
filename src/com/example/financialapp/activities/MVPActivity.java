package com.example.financialapp.activities;

import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.CustomView;

import android.app.Activity;
import android.view.View;

/**
 * Tells the presenter what to do when buttons are tapped.
 * 
 * @author Titus Woo
 */

public abstract class MVPActivity extends Activity implements CustomView {

	/**
	 * Detects when a button is tapped.
	 */

	private ClickListener aListener;

	/**
	 * Calls the listener's onClick method.
	 * 
	 * @param v
	 *            the view the listener is in.
	 */

	@Override
	public void onBtnClick(final View v) {
		aListener.onClick(v);
	}

	/**
	 * Allows the listener to know if the presenter has done something in a
	 * view.
	 * 
	 * @param listener
	 *            the listener in the view being used.
	 */

	@Override
	public void linkNotifyCallback(final ClickListener listener) {
		aListener = listener;
	}
}
