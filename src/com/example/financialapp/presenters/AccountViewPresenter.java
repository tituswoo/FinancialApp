package com.example.financialapp.presenters;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.financialapp.R;
import com.example.financialapp.activities.DepositActivity;
import com.example.financialapp.activities.WithdrawActivity;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.AccountView;
import com.example.financialapp.views.ClickListener;

public class AccountViewPresenter implements ClickListener {
	private AccountView view;
	private Activity activity;

	public AccountViewPresenter(AccountView v, Activity a) {
		view = v;
		view.linkNotifyCallback(this);
		activity = a;
	}

	public void update() {
		view.setBalance(UserModel.getCurrentUser().getAccountModel()
				.getCurrentAccount().getBalance());
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_deposit:
			launchDepositActivity();
			Log.i("Taps", "Deposit button tapped.");
			break;
		case R.id.button_withdraw:
			launchWithdrawActivity();
			Log.i("Taps", "Withdraw button tapped.");
			break;
		default:
			Log.i("Warning", "Something weird happened.");
		}
	}

	private void launchDepositActivity() {
		activity.startActivity(new Intent(activity, DepositActivity.class));
	}

	private void launchWithdrawActivity() {
		activity.startActivity(new Intent(activity, WithdrawActivity.class));
	}

}
