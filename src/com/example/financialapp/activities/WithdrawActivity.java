package com.example.financialapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.example.financialapp.R;
import com.example.financialapp.presenters.WithdrawViewPresenter;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.DepositView;
import com.example.financialapp.views.WithdrawView;

public class WithdrawActivity extends Activity implements WithdrawView {

	WithdrawViewPresenter presenter;
	private ClickListener listener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_withdraw);
		
		presenter = new WithdrawViewPresenter(this, this);
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

	@Override
	public double getAmount() {
		EditText amountForm = (EditText) findViewById(R.id.withdraw_amount);
		double amount;
		try {
			amount = Double.parseDouble(amountForm.getText().toString());
		} catch(NumberFormatException e) {
			amount = -1;
		}
		return amount;
	}

	@Override
	public String getDescription() {
		EditText description = (EditText) findViewById(R.id.withdraw_description);
		return description.getText().toString();
	}

}
