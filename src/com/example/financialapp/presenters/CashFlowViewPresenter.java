package com.example.financialapp.presenters;

import java.util.Date;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.example.financialapp.R;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.CashFlowView;
import com.example.financialapp.views.ClickListener;

/**
 * Presenter for the cash flow report.
 * 
 * @author Samuel
 *
 */
public class CashFlowViewPresenter implements ClickListener {
    /**
     * View for UI elements.
     */
    private CashFlowView view;
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
     * This constructor gets references to the CashFlowView and the main activity
     * it's from (so that it can launch intents).
     * 
     * @param v
     *            The view.
     * @param a
     *            The activity (for launching intents).
     */
    public CashFlowViewPresenter(CashFlowView v, Activity a) {
        view = v;
        view.linkNotifyCallback(this);
        activity = a;
    }

    /**
     * Updates the data with the date range and the income, expenses, and flow of that date range.
     */
    public void update() {
        startDate = view.getStartDate();
        endDate = view.getEndDate();
        setDateRange();
        setIncome();
        setExpenses();
        setFlow();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dateUpdate:
                update();
                break;
            default:
                Log.i("Warning", "Something weird happened.");
        }
    }

    /**
     * Sets the date range.
     */
    private void setDateRange() {
        view.setDateRange(startDate, endDate);
    }

    /**
     * Sets the income.
     */
    private void setIncome() {
        double income = UserModel.getIncome(startDate, endDate);
        view.setIncome(income);
    }

    /**
     * Sets the expenses.
     */
    private void setExpenses() {
        double expenses = UserModel.getExpenses(startDate, endDate);
        view.setExpenses(expenses);
    }

    /**
     * Sets the flow.
     */
    private void setFlow() {
        double flow = UserModel.getIncome(startDate, endDate)
                + UserModel.getExpenses(startDate, endDate);
        view.setFlow(flow);
    }

}
