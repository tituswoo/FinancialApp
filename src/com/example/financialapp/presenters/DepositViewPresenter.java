package com.example.financialapp.presenters;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.financialapp.R;
import com.example.financialapp.activities.AccountListActivity;
import com.example.financialapp.activities.CreateAccountActivity;
import com.example.financialapp.activities.DepositActivity;
import com.example.financialapp.activities.NetworkTestActivity;
import com.example.financialapp.models.Account;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.DepositView;

public class DepositViewPresenter implements ClickListener {
	private DepositView view;
	private Activity activity;
	
	public DepositViewPresenter(DepositView v, Activity a) {
		view = v;
		view.linkNotifyCallback(this);
		activity = a;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.button_deposit:
			deposit();
			Toast.makeText(activity.getApplicationContext(), "Deposit Made", Toast.LENGTH_SHORT).show();
			activity.finish();
			Log.i("Taps", "Deposit button tapped.");
			break;
		default:
			Log.i("Warning", "Something weird happened.");
		}
	}
	
	private void deposit() {
		Account account = UserModel.getCurrentUser().getAccountModel().getCurrentAccount();
		account.deposit(view.getAmount(), view.getDescription());
	}
}
