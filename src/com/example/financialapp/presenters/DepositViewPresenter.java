package com.example.financialapp.presenters;

import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.financialapp.R;
import com.example.financialapp.models.Deposit;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.DepositView;

/**
 * Presenter for making a deposit.
 * 
 * @author Samuel
 *
 */
public class DepositViewPresenter implements ClickListener {
    /**
     * View for UI elements.
     */
    private DepositView view;
    /**
     * The main activity.
     */
    private Activity activity;

    /**
     * This constructor gets references to the DepositView and the main activity
     * it's from (so that it can launch intents).
     * 
     * @param v
     *            The view.
     * @param a
     *            The activity (for launching intents).
     */
    public DepositViewPresenter(DepositView v, Activity a) {
        view = v;
        view.linkNotifyCallback(this);
        activity = a;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.enter_deposit:
                if (!checkMonth()) {
                    new AlertDialog.Builder(activity).setTitle("Bad date")
                    .setMessage("Invalid month.")
                    .setNeutralButton("Okay", null).show();
                } else if (!checkDay()) {
                    new AlertDialog.Builder(activity).setTitle("Bad date")
                    .setMessage("Invalid day.")
                    .setNeutralButton("Okay", null).show();
                } else if (!checkYear()) {
                    new AlertDialog.Builder(activity).setTitle("Bad date")
                    .setMessage("Invalid year.")
                    .setNeutralButton("Okay", null).show();
                } else {
                    new AlertDialog.Builder(activity).setTitle("Success!")
                    .setMessage("Transaction recorded.")
                    .setNeutralButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(
                                DialogInterface dialog,
                                int which) {
                            deposit();
                            activity.finish();
                        }
                    }).show();
                    
                }
                Log.i("Taps", "Deposit button tapped.");
                break;
            default:
                Log.i("Warning", "Something weird happened.");
        }
    }

    /**
     * Makes a deposit with the given amount, description, and category.
     * 
     * @return
     *          True if deposit is successful, false otherwise.
     */
    private boolean checkMonth() {
        if (view.getMonth().length() != 2) {
            return false;
        } else if (Integer.parseInt(view.getMonth(),10) <=0) {
            return false;
        }else if (Integer.parseInt(view.getMonth(),10) > 12) {
            return false;
        } else {
            return true;
        }
    }
    
    
    
    private boolean checkDay() {
        if (view.getDay().length() != 2) {
            return false;
        }
        int month = Integer.parseInt(view.getMonth(),10);
        int day = Integer.parseInt(view.getDay(),10);
        if (month <= 0) {
            return false;
        } else if (month == 2 && day > 28) {
            return false;
        } else if ((month % 2 == 0 || month != 8) && day > 30) {
            return false;
        } else if (day > 31) {
            return false;
        } else {
            return true;
        }
    }
    
    private boolean checkYear() {
        if (view.getYear().length() != 4) {
            return false;
        } else {
            return true;
        }
    }
    
    private boolean deposit() {
        double amount = view.getAmount();
        String description = view.getDescription();
        String category = view.getCategory();
        String userDate = view.getUserDateString();
        String type = "Deposit";
        String status = "Committed";
        Date date = view.getUserDate();
        UserModel.getCurrentUser().getAccountModel().getCurrentAccount()
                .add(new Deposit(amount, description, category, date, userDate, type, status));
        return true;
    }
}
