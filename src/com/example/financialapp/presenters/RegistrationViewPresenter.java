package com.example.financialapp.presenters;

import com.example.financialapp.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.util.Log;
import android.view.View;

import com.example.financialapp.models.User;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.RegistrationView;

public class RegistrationViewPresenter implements ClickListener {
	
	private RegistrationView view;
	private Activity activity;
	
	public RegistrationViewPresenter(RegistrationView v, Activity a) {
		view = v;
		view.linkNotifyCallback(this);
		activity = a;
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.register_button:
			if (register()) {
				new AlertDialog.Builder(activity)
					.setTitle("Yay")
					.setMessage("Registered successfully!")
					.setNeutralButton("Okay", null)
					.show();
			} else {
				new AlertDialog.Builder(activity)
					.setTitle("Eww")
					.setMessage("Bad credentials.")
					.setNeutralButton("Fine", null)
					.show();
			}
			Log.i("Taps", "Register New User button tapped.");
			break;
		default:
			Log.i("Warning", "Something weird happened.");
		}
	}
	
	private boolean register() {
		if(!view.getConfirmPassword().equals(view.getPassword())) {
			return false;
		}
		User newUser = new User(view.getUsername(), view.getFirstName(), view.getLastName(), view.getPassword());
		return UserModel.addUser(newUser);
	}
}
