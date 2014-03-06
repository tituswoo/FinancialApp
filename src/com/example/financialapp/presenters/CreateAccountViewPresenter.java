package com.example.financialapp.presenters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.financialapp.R;
import com.example.financialapp.models.Account;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.CreateAccountView;

public class CreateAccountViewPresenter implements ClickListener {
	
	private CreateAccountView view;
	private Activity activity;
	
	public CreateAccountViewPresenter(CreateAccountView v, Activity a) {
		view = v;
		view.linkNotifyCallback(this);
		activity = a;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.create_button:
			if(validAccount()) {
				addAccount();
				Toast.makeText(activity.getApplicationContext(), "Account Created", Toast.LENGTH_SHORT).show();
				activity.finish();
			} else {
				new AlertDialog.Builder(activity)
				.setTitle("Uh oh")
				.setMessage("You didn't enter an account name!")
				.setNeutralButton("Ok", null)
				.show();
			}
			Log.i("Taps", "Create button tapped");
			break;
		case R.id.cancel_button:
			activity.finish();
			Log.i("Taps", "Cancel button tapped");
			break;
		default:
			Log.i("Warning", "Something weird happened");
		}
	}
	
	private boolean validAccount() {
		boolean valid = true;
		String accountName = view.getAccountName();
		if (accountName.length() <= 0) {
			valid = false;
		}
		return valid;
	}
	private void addAccount() {
		Account a = new Account(view.getAccountName());
		UserModel.getCurrentUser().getAccountModel().addAccount(UserModel.getCurrentUser(), a);
	}

}
