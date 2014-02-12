package com.example.financialapp.activities;

import com.example.financialapp.R;
import com.example.financialapp.R.layout;
import com.example.financialapp.R.menu;
import com.example.financialapp.presenters.WelcomeViewPresenter;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.WelcomeView;

import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity implements WelcomeView {
	
	WelcomeViewPresenter presenter;
	private ClickListener listener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		presenter = new WelcomeViewPresenter(this, this);
	}
	
	public void onBtnClick(View v) {
		listener.onClick(v);
	}
	
	@Override
	public void linkNotifyCallback(final ClickListener listener) {
		this.listener = listener;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
