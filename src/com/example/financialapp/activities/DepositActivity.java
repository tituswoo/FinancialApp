package com.example.financialapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.example.financialapp.R;
import com.example.financialapp.presenters.DepositViewPresenter;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.DepositView;

public class DepositActivity extends MVPActivity implements DepositView {

	DepositViewPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deposit);

		presenter = new DepositViewPresenter(this, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public double getAmount() {
		EditText amountForm = (EditText) findViewById(R.id.deposit_amount);
		double amount;
		try {
			amount = Double.parseDouble(amountForm.getText().toString());
		} catch (NumberFormatException e) {
			amount = -1;
		}
		return amount;
	}

	@Override
	public String getDescription() {
		EditText description = (EditText) findViewById(R.id.deposit_description);
		return description.getText().toString();
	}

}
