package com.example.financialapp.activities;

import com.example.financialapp.R;
import com.example.financialapp.models.User;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.presenters.DashboardViewPresenter;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.DashboardView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends MVPActivity implements DashboardView {

	DashboardViewPresenter presenter;
	private TextView currentUser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		currentUser = (TextView) findViewById(R.id.currentUser);
		setCurrentUser(UserModel.getCurrentUser());
		presenter = new DashboardViewPresenter(this, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dashboard, menu);
		return true;
	}

	public void setCurrentUser(User current) {
		currentUser.setText("Logged in as " + current.toString());
	}

}
