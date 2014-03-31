package com.example.financialapp.presenters;

import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.util.Log;
import android.view.View;

import com.example.financialapp.R;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.IncomeSourceView;
import com.example.financialapp.views.ClickListener;

public class IncomeSourceViewPresenter implements ClickListener {
    private IncomeSourceView view;
    private Activity activity;
    private Date startDate, endDate;
    private AlertDialog alertDialogStores;

    public IncomeSourceViewPresenter(IncomeSourceView v, Activity a) {
        view = v;
        view.linkNotifyCallback(this);
        activity = a;
        update();
    }

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

    private void setDateRange() {
        view.setDateRange(startDate, endDate);
    }

    private void setSalary() {
        double salary = UserModel.getIncomeSource("Salary", startDate, endDate);
        view.setSalary(salary);
    }

    private void setBirthday() {
        double birthday = UserModel.getIncomeSource("Birthday", startDate,
                endDate);
        view.setBirthday(birthday);
    }

    private void setParents() {
        double parents = UserModel.getIncomeSource("Parents", startDate,
                endDate);
        view.setParents(parents);
    }

    private void setScholarship() {
        double scholarship = UserModel.getIncomeSource("Scholarship",
                startDate, endDate);
        view.setScholarship(scholarship);
    }

    private void setOther() {
        double other = UserModel.getIncomeSource("Other", startDate, endDate);
        view.setOther(other);
    }

    private void setTotal() {
        double total = UserModel.getIncome(startDate, endDate);
        view.setTotal(total);
    }
}
