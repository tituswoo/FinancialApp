package com.example.financialapp.activities;

import com.example.financialapp.R;
import com.example.financialapp.R.layout;
import com.example.financialapp.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class WithdrawActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_withdraw);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.withdraw, menu);
		return true;
	}

}
