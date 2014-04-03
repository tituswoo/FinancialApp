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

/**
 * Presenter for the withdraw screen.
 * 
 * @author Samuel
 *
 */
public class WithdrawViewPresenter implements ClickListener {
    /**
     * View for UI elements.
     */
    private WithdrawView view;
    /**
     * The main activity.
     */
    private Activity activity;

    /**
     * This constructor gets references to the WithdrawView and the main activity
     * it's from (so that it can launch intents).
     * 
     * @param v
     *            The view.
     * @param a
     *            The activity (for launching intents).
     */
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

    /**
     * Makes a withdrawal with the given amount, description, and category.
     * 
     * @return
     *          True if the withdrawal was successful, false otherwise.
     */
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
