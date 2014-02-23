package com.example.financialapp.activities;

import com.example.financialapp.R;
import com.example.financialapp.presenters.DashboardViewPresenter;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.DashboardView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class DashboardActivity extends Activity implements DashboardView {
	
	DashboardViewPresenter presenter;
	private ClickListener listener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		
		presenter = new DashboardViewPresenter(this, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dashboard, menu);
		return true;
	}
	
	@Override
	public void linkNotifyCallback(ClickListener listener) {
		this.listener = listener;
	}
	
	public void onBtnClick(View v) {
		listener.onClick(v);
	}
	

}
