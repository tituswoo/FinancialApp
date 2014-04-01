package com.example.financialapp.presenters;

import com.example.financialapp.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.financialapp.activities.DashboardActivity;
import com.example.financialapp.database.Database;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.LoginView;

public class LoginViewPresenter implements ClickListener {

	private LoginView view;
	private Activity activity;

	public LoginViewPresenter(LoginView v, Activity a) {
		view = v;
		view.linkNotifyCallback(this);
		activity = a;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_btn:
			if (login()) {
				launchDashboardActivity();
			} else {
				new AlertDialog.Builder(activity).setTitle("Eww")
						.setMessage("Bad credentials.")
						.setNeutralButton("Fine", null).show();
			}
			Log.i("Taps", "Login button tapped.");
			break;
		default:
			Log.i("Warning", "Something weird happened.");
		}
	}

	private boolean login() {
		String username = view.getUsername();
		String password = view.getPassword();
		Log.i("Info", "Username: " + username);
		Log.i("Info", "Password: " + password);
		return UserModel.login(username, password);
	}

	private void launchDashboardActivity() {
		Intent intent = new Intent(activity, DashboardActivity.class);
		activity.startActivity(intent);
	}
}
