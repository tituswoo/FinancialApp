package com.example.financialapp.activities;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.example.financialapp.R;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.presenters.AccountViewPresenter;
import com.example.financialapp.views.AccountView;

/**
 * Handles account page of app.
 *
 * @author Vishal Erabelli
 *
 */

public class AccountActivity extends MVPActivity implements AccountView {

	/**
	 * Carries out any actions in the account page.
	 */

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
		// Inflate the menu; this adds items to the action bar if it
		// is present.
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
		DecimalFormat dcf = new DecimalFormat("#0.00");
		balanceView.setText("Account Balance: $" + dcf.format(balance));
	}

	@Override
	public void setAccountName() {
		TextView accountNameView =
			(TextView) findViewById(R.id.account_name);
		accountNameView.setText(
			UserModel.getCurrentUser().getAccountModel()
				.getCurrentAccount().getName());
	}

}
