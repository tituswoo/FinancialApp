package com.example.financialapp.activities;

import com.example.financialapp.R;
import com.example.financialapp.models.User;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.presenters.DashboardViewPresenter;
import com.example.financialapp.views.DashboardView;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

/**
 * Opens dashboard view with options to create/view accounts, as well as viewing
 * reports.
 *
 * @author Toma Tadros
 *
 */

public class DashboardActivity extends MVPActivity implements DashboardView {

	/**
	 * presenter handles all operations within the view.
	 */
	private DashboardViewPresenter presenter;
	/**
	 * currentUser is the user currently logged into the app.
	 */
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
		// Inflate the menu; this adds items to the action bar if it
		// is present.
		getMenuInflater().inflate(R.menu.dashboard, menu);
		return true;
	}

	@Override
	public void setCurrentUser(User current) {
		currentUser.setText("Logged in as " + current.toString());
	}

}
