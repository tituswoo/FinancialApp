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

public class DepositActivity extends Activity implements DepositView {

	DepositViewPresenter presenter;
	private ClickListener listener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deposit);
		
		presenter = new DepositViewPresenter(this, this);
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
		EditText amount = (EditText) findViewById(R.id.deposit_amount);
		return Double.parseDouble(amount.getText().toString());
	}

	@Override
	public String getDescription() {
		EditText description = (EditText) findViewById(R.id.deposit_description);
		return description.getText().toString();
	}

}
