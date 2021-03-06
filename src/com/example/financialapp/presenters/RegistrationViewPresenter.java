package com.example.financialapp.presenters;

import com.example.financialapp.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;

import com.example.financialapp.models.User;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.RegistrationView;

/**
 * Presenter for the registration screen.
 * 
 * @author Samuel
 *
 */
public class RegistrationViewPresenter implements ClickListener {

    /**
     * View for UI elements.
     */
    private RegistrationView view;
    /**
     * The main activity.
     */
    private Activity activity;

    /**
     * This constructor gets references to the RegistrationView and the main activity
     * it's from (so that it can launch intents).
     * 
     * @param v
     *            The view.
     * @param a
     *            The activity (for launching intents).
     */
    public RegistrationViewPresenter(RegistrationView v, Activity a) {
        view = v;
        view.linkNotifyCallback(this);
        activity = a;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_button:
                if (registrationIsValid()) {
                    if (registerUser()) {
                        new AlertDialog.Builder(activity)
                            .setTitle("Yay")
                            .setMessage("Registered successfully!")
                            .setPositiveButton("Take me to login",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(
                                                DialogInterface dialog,
                                                int which) {
                                            activity.finish();
                                        }
                                    }).show();
                    } else {
                        new AlertDialog.Builder(activity)
                            .setTitle("Uh oh")
                            .setMessage(
                                    "Something went wrong when we tried to create your account.")
                            .setNeutralButton("Okay", null).show();
                    }

                } else {
                    new AlertDialog.Builder(activity)
                        .setTitle("Eww")
                        .setMessage(
                                "Something's not filled out correctly. Please try again.")
                        .setNeutralButton("Okay", null).show();
                }
                Log.i("Taps", "Register New User button tapped.");
                break;
            default:
                Log.i("Warning", "Something weird happened.");
        }
    }

    /**
     * Registers the user.
     * 
     * @return
     *          True if the user was added, false otherwise.
     */
    private boolean registerUser() {
        User newUser = new User(view.getUsername(), view.getFirstName(),
                view.getLastName(), view.getPassword());
        return UserModel.addUser(newUser);
    }

    
    /**
     * Checks if the registration is valid.
     * 
     * @return
     *          True if the registration is valid, false otherwise.
     */
    private boolean registrationIsValid() {
        boolean valid = true;

        String pswd1 = view.getPassword();
        String pswd2 = view.getConfirmPassword();
        String fName = view.getFirstName();
        String lName = view.getLastName();
        String username = view.getUsername();

        if (!pswd1.equals(pswd2)) {
            valid = false;
        }
        if (pswd1.equals("") || pswd2.equals("") || fName.equals("")
                || lName.equals("") || username.equals("")) {
            valid = false;
        }

        return valid;
    }
}
