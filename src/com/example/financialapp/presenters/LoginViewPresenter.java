package com.example.financialapp.presenters;

import com.example.financialapp.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.financialapp.activities.DashboardActivity;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.LoginView;

/**
 * Presenter for the login screen.
 * 
 * @author Samuel
 *
 */
public class LoginViewPresenter implements ClickListener {

    /**
     * View for UI elements.
     */
    private LoginView view;
    /**
     * The main activity.
     */
    private Activity activity;

    /**
     * This constructor gets references to the LoginView and the main activity
     * it's from (so that it can launch intents).
     * 
     * @param v
     *            The view.
     * @param a
     *            The activity (for launching intents).
     */
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

    /**
     * Gets the username and password and logs the user into the user model.
     * 
     * @return
     *          True if login is successful, false otherwise.
     */
    private boolean login() {
        String username = view.getUsername();
        String password = view.getPassword();

        Log.i("Info", "Username: " + username);
        Log.i("Info", "Password: " + password);

        return UserModel.login(username, password);
    }

    /**
     * Launches the dashboard screen.
     */
    private void launchDashboardActivity() {
        Intent intent = new Intent(activity, DashboardActivity.class);
        activity.startActivity(intent);
    }
}
