package com.example.financialapp.activities;

import com.example.financialapp.R;
import com.example.financialapp.presenters.RegistrationViewPresenter;
import com.example.financialapp.views.RegistrationView;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

/**
 * Opens view to allow a new user to register for the app.
 *
 * @author Vishal Erabelli
 *
 */

public class RegistrationActivity extends MVPActivity implements
		RegistrationView {

	/**
	 * presenter handles all operation within the view.
	 */

	private RegistrationViewPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);

		presenter = new RegistrationViewPresenter(this, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it
		// is present.
		getMenuInflater().inflate(R.menu.registration, menu);
		return true;
	}

	@Override
	public String getFirstName() {
		EditText editText =
			(EditText) findViewById(R.id.firstName_editText);
		return editText.getText().toString();
	}

	@Override
	public String getLastName() {
		EditText editText =
			(EditText) findViewById(R.id.lastName_editText);
		return editText.getText().toString();
	}

	@Override
	public String getUsername() {
		EditText editText =
			(EditText) findViewById(R.id.newUsername_editText);
		return editText.getText().toString();
	}

	@Override
	public String getPassword() {
		EditText editText =
			(EditText) findViewById(R.id.newPassword_editText);
		return editText.getText().toString();
	}

	@Override
	public String getConfirmPassword() {
		EditText editText =
			(EditText) findViewById(
				R.id.newConfirmPassword_editText);
		return editText.getText().toString();
	}
}
