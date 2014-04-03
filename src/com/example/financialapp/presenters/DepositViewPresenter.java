package com.example.financialapp.presenters;

import android.app.Activity;
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
                if (deposit()) {
                    Toast.makeText(activity.getApplicationContext(),
                        "Transaction Recorded", Toast.LENGTH_SHORT).show();
                    activity.finish();
                } else {
                    Toast.makeText(activity.getApplicationContext(),
                        "Invalid Input!", Toast.LENGTH_LONG);
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
    private boolean deposit() {
        double amount = view.getAmount();
        if (amount < 0) {
            return false;
        }
        String description = view.getDescription();
        String category = view.getCategory();
        UserModel.getCurrentUser().getAccountModel().getCurrentAccount()
                .add(new Deposit(amount, description, category));
        return true;
    }
}
