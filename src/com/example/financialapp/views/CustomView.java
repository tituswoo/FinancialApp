package com.example.financialapp.views;

import android.view.View;

/**
 * This prives base functionality for our custom views.
 * @author Titus Woo
 *
 */
public interface CustomView {
	/*
	 * This is the hook that grants the WelcomeViewPresenter access
	 * to the view. In other words, this lets the view communicate with
	 * the WelcomeViewPresenter.
	 */
	public void linkNotifyCallback(ClickListener listener);
	public void onBtnClick(View v);
}