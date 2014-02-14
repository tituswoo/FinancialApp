package com.example.financialapp.activities;

import com.example.financialapp.R;
import com.example.financialapp.presenters.LoginViewPresenter;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.LoginView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity implements LoginView {
	
	LoginViewPresenter presenter;
	private ClickListener listener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		presenter = new LoginViewPresenter(this, this);
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
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	public String getUsername() {
		EditText editText = (EditText)findViewById(R.id.username_editText);
		return editText.getText().toString();
	}
	
	public String getPassword() {
		EditText editText = (EditText)findViewById(R.id.password_editText);
		return editText.getText().toString();
	}
}