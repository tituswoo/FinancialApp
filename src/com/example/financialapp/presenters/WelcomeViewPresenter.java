package com.example.financialapp.presenters;

// import android.R; // this gave me "cannot resolve" problems, cuz this is the wrong scope.
import com.example.financialapp.R;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.financialapp.activities.LoginActivity;
import com.example.financialapp.activities.RegistrationActivity;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.WelcomeView;

/**
 * This presenter doesn't need a model.
 * 
 * @author Titus Woo
 * 
 */

public class WelcomeViewPresenter implements ClickListener {

    private WelcomeView view;
    private Activity activity;

    /**
     * This constructor gets references to the WelcomeView and the main activity
     * it's from (so that it can launch intents).
     * 
     * @param v
     *            The view.
     * @param a
     *            The activity (for launching intents).
     */
    public WelcomeViewPresenter(WelcomeView v, Activity a) {
        view = v;
        view.linkNotifyCallback(this);
        activity = a;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.login_btn:
            launchLoginActivity();
            Log.i("Taps", "Login button tapped.");
            break;
        case R.id.register_btn:
            launchRegisterActivity();
            Log.i("Taps", "Register button tapped.");
            break;
        default:
            Log.i("Warning", "Something weird happened.");
        }
    }

    private void launchLoginActivity() {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
    }

    private void launchRegisterActivity() {
        activity.startActivity(new Intent(activity, RegistrationActivity.class));
    }
}
