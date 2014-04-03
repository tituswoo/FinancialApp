package com.example.financialapp.presenters;

import java.util.Date;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.example.financialapp.R;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.IncomeSourceView;
import com.example.financialapp.views.ClickListener;

/**
 * Presenter for the income source report.
 * 
 * @author Samuel
 *
 */
public class IncomeSourceViewPresenter implements ClickListener {
    /**
     * View for UI elements.
     */
    private IncomeSourceView view;
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
     * This constructor gets references to the IncomeSourceView and the main activity
     * it's from (so that it can launch intents).
     * 
     * @param v
     *            The view.
     * @param a
     *            The activity (for launching intents).
     */
    public IncomeSourceViewPresenter(IncomeSourceView v, Activity a) {
        view = v;
        view.linkNotifyCallback(this);
        activity = a;
    }

    /**
     * Updates the data with the date range and the income for the five given sources of that date range. Also shows total income.
     */
    public void update() {
        startDate = view.getStartDate();
        endDate = view.getEndDate();
        setDateRange();
        setSalary();
        setBirthday();
        setParents();
        setScholarship();
        setOther();
        setTotal();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.incomeSourceReportDateUpdate:
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
     * Sets the salary income.
     */
    private void setSalary() {
        double salary = UserModel.getIncomeSource("Salary", startDate, endDate);
        view.setSalary(salary);
    }

    /**
     * Sets the birthday income.
     */
    private void setBirthday() {
        double birthday = UserModel.getIncomeSource("Birthday", startDate,
                endDate);
        view.setBirthday(birthday);
    }

    /**
     * Sets the parents income.
     */
    private void setParents() {
        double parents = UserModel.getIncomeSource("Parents", startDate,
                endDate);
        view.setParents(parents);
    }

    /**
     * Sets the scholarship income.
     */
    private void setScholarship() {
        double scholarship = UserModel.getIncomeSource("Scholarship",
                startDate, endDate);
        view.setScholarship(scholarship);
    }

    /**
     * Sets the other income.
     */
    private void setOther() {
        double other = UserModel.getIncomeSource("Other", startDate, endDate);
        view.setOther(other);
    }

    /**
     * Sets the total income.
     */
    private void setTotal() {
        double total = UserModel.getIncome(startDate, endDate);
        view.setTotal(total);
    }
}
