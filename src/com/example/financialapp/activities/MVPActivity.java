package com.example.financialapp.activities;

import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.CustomView;

import android.app.Activity;
import android.view.View;

public abstract class MVPActivity extends Activity implements CustomView {
	
	private ClickListener listener;
	
	public void onBtnClick(View v) {
		listener.onClick(v);
	}
	
	@Override
	public void linkNotifyCallback(final ClickListener listener) {
		this.listener = listener;
	}
}
