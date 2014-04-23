package com.example.financialapp.presenters;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.financialapp.R;
import com.example.financialapp.activities.TransactionHistoryActivity;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.DateSetterView;

public class DateSetterViewPresenter implements ClickListener{
    private DateSetterView view;
    /**
     * The main activity.
     */
    private Activity activity;
    /**
     * The starting date.
     */
    private Date startDate;
    /**
     * The ending date.
     */
    private Date endDate;
    
    /**
     * This constructor gets references to the DateSetterView and the main activity
     * it's from (so that it can launch intents).
     * 
     * @param v
     *            The view.
     * @param a
     *            The activity (for launching intents).
     */
    public DateSetterViewPresenter(DateSetterView v, Activity a) {
        view = v;
        view.linkNotifyCallback(this);
        activity = a;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dateSetter_Button_transactionHistory:
                startDate = view.getStartDate();
                endDate = view.getEndDate();
                setDateRange(startDate, endDate);
                launchTransactionHistoryActivity();
                break;
            default:
                Log.i("Warning", "Something weird happened.");
        }
    }

    /**
     * Sets the date range.
     */
    private void setDateRange(Date startDate, Date endDate) {
        UserModel.getCurrentUser().setStartDate(startDate);
        UserModel.getCurrentUser().setEndDate(endDate);
    }
    
    private void launchTransactionHistoryActivity() {
        activity.startActivity(new Intent(activity, TransactionHistoryActivity.class));
    }
}
