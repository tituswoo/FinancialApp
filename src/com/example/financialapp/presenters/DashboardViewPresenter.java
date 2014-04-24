package com.example.financialapp.presenters;

import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.financialapp.R;
import com.example.financialapp.activities.AccountBalancesActivity;
import com.example.financialapp.activities.AccountListActivity;
import com.example.financialapp.activities.CashFlowReportActivity;
import com.example.financialapp.activities.CreateAccountActivity;
import com.example.financialapp.activities.DateSetterActivity;
import com.example.financialapp.activities.IncomeSourceReportActivity;
import com.example.financialapp.activities.NetworkTestActivity;
import com.example.financialapp.activities.SpendingCategoryReportActivity;
import com.example.financialapp.activities.UserDateSetterActivity;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.DashboardView;

/**
 * Presenter for the dashboard.
 * 
 * @author Samuel
 *
 */
public class DashboardViewPresenter implements ClickListener {

    /**
     * View for UI elements.
     */
    private DashboardView view;
    /**
     * The main activity.
     */
    private Activity activity;

    /**
     * This constructor gets references to the DashboardView and the main activity
     * it's from (so that it can launch intents).
     * 
     * @param v
     *            The view.
     * @param a
     *            The activity (for launching intents).
     */
    public DashboardViewPresenter(DashboardView v, Activity a) {
        view = v;
        view.linkNotifyCallback(this);
        activity = a;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.new_account:
                launchCreateAccountActivity();
                Log.i("Taps", "New Account button tapped.");
                break;
            case R.id.view_accounts:
                launchAccountListActivity();
                Log.i("Taps", "View Accounts button tapped.");
                break;
            case R.id.cashFlowReportActivity:
                Log.i("Taps", "Cash Flow Report button tapped.");
                launchCashFlowReportActivity();
                break;
            case R.id.spendingCategoryReportActivity:
                Log.i("Taps", "Spending Category Report button tapped");
                launchSpendingCategoryReportActivity();
                break;
            case R.id.dashboard_Button_incomeSourceReport:
                Log.i("Taps", "Income Source Report button tapped");
                launchIncomeSourceReportActivity();
                break;
            case R.id.dashboard_Button_viewAccountBalances:
                new AlertDialog.Builder(activity).setTitle("View Account Balances")
                .setNeutralButton("View For All Transactions", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(
                            DialogInterface dialog,
                            int which) {
                            setDateRange(null,null);
                            launchAccountBalancesActivity();
                    }
                })
                .setPositiveButton("Set Transaction Date Range", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(
                            DialogInterface dialog,
                            int which) {
                            launchUserDateSetterActivity();
                    }
                }).show();
                Log.i("Taps", "View Account Balances button tapped");
                break;
            default:
                Log.i("Warning", "Something weird happened.");
        }
    }

    
    /**
     * Launches the account creation screen.
     */
    private void launchCreateAccountActivity() {
        activity.startActivity(new Intent(activity, CreateAccountActivity.class));
    }

    /**
     * Launches the network test screen.
     */
    private void launchNetworkTestActivity() {
        activity.startActivity(new Intent(activity, NetworkTestActivity.class));
    }

    /**
     * Launches the account list screen.
     */
    private void launchAccountListActivity() {
        activity.startActivity(new Intent(activity, AccountListActivity.class));
    }
    
    private void launchUserDateSetterActivity() {
        activity.startActivity(new Intent(activity, UserDateSetterActivity.class));
    }

    /**
     * Launches the cash flow report screen.
     */
    private void launchCashFlowReportActivity() {
        activity.startActivity(new Intent(activity,
                CashFlowReportActivity.class));
    }

    /**
     * Launches the spending category report screen.
     */
    private void launchSpendingCategoryReportActivity() {
        activity.startActivity(new Intent(activity,
                SpendingCategoryReportActivity.class));
    }

    /**
     * Launches the income source report screen.
     */
    private void launchIncomeSourceReportActivity() {
        activity.startActivity(new Intent(activity,
                IncomeSourceReportActivity.class));
    }
    
    
    private void launchAccountBalancesActivity() {
        activity.startActivity(new Intent(activity,
                AccountBalancesActivity.class));
        
    }
    
    private void setDateRange(Date startDate, Date endDate) {
        UserModel.getCurrentUser().setStartDate(startDate);
        UserModel.getCurrentUser().setEndDate(endDate);
    }
}
