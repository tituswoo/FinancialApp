package com.example.financialapp.presenters;

import java.util.Date;

import com.example.financialapp.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.financialapp.activities.DateSetterActivity;
import com.example.financialapp.activities.DepositActivity;
import com.example.financialapp.activities.TransactionHistoryActivity;
import com.example.financialapp.activities.WithdrawActivity;
import com.example.financialapp.models.Transaction;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.AccountView;
import com.example.financialapp.views.ClickListener;

/**
 * Presenter for an account.
 * 
 * @author Samuel
 *
 */
public class AccountViewPresenter implements ClickListener {
    /**
     * View for UI elements.
     */
    private AccountView view;
    /**
     * Activity to interact with user.
     */
    private Activity activity;

    /**
     * This constructor gets references to the AccountView and the main activity
     * it's from (so that it can launch intents).
     * 
     * @param v
     *            The view.
     * @param a
     *            The activity (for launching intents).
     */
    public AccountViewPresenter(AccountView v, Activity a) {
        view = v;
        view.linkNotifyCallback(this);
        activity = a;
    }

    /**
     * Updates balance.
     */
    public void update() {
        view.setBalance(UserModel.getCurrentUser().getAccountModel()
                .getCurrentAccount().getBalance());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_deposit:
                launchDepositActivity();
                Log.i("Taps", "Deposit button tapped.");
                break;
            case R.id.button_withdraw:
                launchWithdrawActivity();
                Log.i("Taps", "Withdraw button tapped.");
                break;
            case R.id.account_Button_transactionHistory:
                new AlertDialog.Builder(activity).setTitle("Transaction History")
                .setNeutralButton("View All Transactions", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(
                            DialogInterface dialog,
                            int which) {
                            setDateRange(null,null);
                            launchTransactionHistoryActivity();
                    }
                })
                .setPositiveButton("Set Date Range", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(
                            DialogInterface dialog,
                            int which) {
                            launchDateSetterActivity();
                    }
                }).show();
                Log.i("Taps", "TransactionHistory button tapped.");
                break;
            default:
                Log.i("Warning", "Something weird happened.");
        }
    }

    /**
     * Launches the deposit screen.
     */
    private void launchDepositActivity() {
        activity.startActivity(new Intent(activity, DepositActivity.class));
    }

    /**
     * Launches the withdraw screen.
     */
    private void launchWithdrawActivity() {
        activity.startActivity(new Intent(activity, WithdrawActivity.class));
    }
    /**
     * Launches the transaction history screen.
     */
    private void launchDateSetterActivity() {
        activity.startActivity(new Intent(activity, DateSetterActivity.class));
    }
    
    private void launchTransactionHistoryActivity() {
        activity.startActivity(new Intent(activity, TransactionHistoryActivity.class));
    }
    
    private void setDateRange(Date startDate, Date endDate) {
        UserModel.getCurrentUser().setStartDate(startDate);
        UserModel.getCurrentUser().setEndDate(endDate);
    }

}
