package com.example.financialapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.example.financialapp.R;
import com.example.financialapp.presenters.WelcomeViewPresenter;
import com.example.financialapp.views.WelcomeView;

/**
 * Opens start page of the app.
 * @author Titus Woo
 *
 */

public class MainActivity extends MVPActivity implements WelcomeView {

	/**
	 * presenter handles all operations within the view.
	 */

	private WelcomeViewPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startActivity(new Intent(this, SplashActivity.class));
		presenter = new WelcomeViewPresenter(this, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if
		// it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
