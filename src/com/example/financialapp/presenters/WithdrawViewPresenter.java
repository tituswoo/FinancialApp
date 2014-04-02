package com.example.financialapp.presenters;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.financialapp.R;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.models.Withdrawal;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.WithdrawView;

public class WithdrawViewPresenter implements ClickListener {
	private WithdrawView view;
	private Activity activity;

	public WithdrawViewPresenter(WithdrawView v, Activity a) {
		view = v;
		view.linkNotifyCallback(this);
		activity = a;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.enter_withdraw:
			if (withdraw()) {
				Toast.makeText(activity.getApplicationContext(),
						"Transaction Recorded", Toast.LENGTH_SHORT).show();
				activity.finish();
			} else {
				Toast.makeText(activity.getApplicationContext(),
						"Invalid Input!", Toast.LENGTH_LONG).show();
			}
			Log.i("Taps", "Deposit button tapped.");
			break;
		default:
			Log.i("Warning", "Something weird happened.");
		}
	}

	private boolean withdraw() {
		double amount = view.getAmount();
		if (amount < 0) {
			return false;
		}
		String description = view.getDescription();
		String category = view.getCategory();
		UserModel.getCurrentUser().getAccountModel().getCurrentAccount()
				.add(new Withdrawal(amount, description, category));
		return true;
	}
}
