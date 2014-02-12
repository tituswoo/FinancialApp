package com.example.financialapp.views;

import android.view.View;

/**
 * This interface ensures that presenters can do stuff when their
 * views report a tap/click event.
 * 
 * @author Titus Woo
 *
 */
public interface ClickListener {
	void onClick(View v);
}