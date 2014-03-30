package com.example.financialapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.example.financialapp.R;
import com.example.financialapp.R.id;
import com.example.financialapp.R.layout;
import com.example.financialapp.R.menu;
import com.example.financialapp.models.Account;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.presenters.AccountViewPresenter;
import com.example.financialapp.views.AccountView;
import com.example.financialapp.views.ClickListener;

public class AccountActivity extends MVPActivity implements AccountView {

	private AccountViewPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);
		presenter = new AccountViewPresenter(this, this);
		setAccountName();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account, menu);
		return true;
	}

	@Override
	public void onResume() {
		super.onResume();
		presenter.update();
	}

	@Override
	public void setBalance(double balance) {
		TextView balanceView = (TextView) findViewById(R.id.balance);
		balanceView.setText("Account Balance: " + balance);
	}

	@Override
	public void setAccountName() {
		TextView accountNameView = (TextView) findViewById(R.id.account_name);
		accountNameView.setText(UserModel.getCurrentUser().getAccountModel()
				.getCurrentAccount().getName());
	}

}
