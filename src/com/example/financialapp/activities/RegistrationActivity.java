package com.example.financialapp.activities;

import com.example.financialapp.R;
import com.example.financialapp.R.layout;
import com.example.financialapp.R.menu;
import com.example.financialapp.presenters.RegistrationViewPresenter;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.RegistrationView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class RegistrationActivity extends Activity implements RegistrationView {

	RegistrationViewPresenter presenter;
	private ClickListener listener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		
		presenter = new RegistrationViewPresenter(this, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registration, menu);
		return true;
	}
	
	public void onBtnClick(View v) {
		listener.onClick(v);
	}
	
	public void linkNotifyCallback(final ClickListener listener) {
		this.listener = listener;
	}
	
	public String getFirstName() {
		EditText editText = (EditText)findViewById(R.id.firstName_editText);
		return editText.getText().toString();
	}
	
	public String getLastName() {
		EditText editText = (EditText)findViewById(R.id.lastName_editText);
		return editText.getText().toString();
	}
	
	public String getUsername() {
		EditText editText = (EditText)findViewById(R.id.newUsername_editText);
		return editText.getText().toString();
	}
	
	public String getPassword() {
		EditText editText = (EditText)findViewById(R.id.newPassword_editText);
		return editText.getText().toString();
	}
	
	public String getConfirmPassword() {
		EditText editText = (EditText)findViewById(R.id.newConfirmPassword_editText);
		return editText.getText().toString();
	}
	

}
