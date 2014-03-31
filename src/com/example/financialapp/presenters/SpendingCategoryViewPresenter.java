package com.example.financialapp.presenters;

import java.util.Date;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.example.financialapp.R;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.SpendingCategoryView;

public class SpendingCategoryViewPresenter implements ClickListener {

    private SpendingCategoryView view;
    private Activity activity;
    Date startDate, endDate;

    public SpendingCategoryViewPresenter(SpendingCategoryView v, Activity a) {
        view = v;
        view.linkNotifyCallback(this);
        activity = a;
        update();
    }

    public void update() {
        startDate = view.getStartDate();
        endDate = view.getEndDate();
        setDateRange();
        setFoodExpense();
        setRentExpense();
        setEntertainmentExpense();
        setClothingExpense();
        setOtherExpense();
        setTotalExpense();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.button_spendingCategory_update:
            update();
            break;
        default:
            Log.i("Warning", "Something weird happened.");
        }
    }

    private void setDateRange() {
        view.setDateRange(startDate, endDate);
    }

    private void setFoodExpense() {
        double expense = UserModel.getFoodExpense(startDate, endDate);
        view.setFoodExpense(expense);
    }

    private void setRentExpense() {
        double expense = UserModel.getRentExpense(startDate, endDate);
        view.setRentExpense(expense);
    }

    private void setEntertainmentExpense() {
        double expense = UserModel.getEntertainmentExpense(startDate, endDate);
        view.setEntertainmentExpense(expense);
    }

    private void setClothingExpense() {
        double expense = UserModel.getClothingExpense(startDate, endDate);
        view.setClothingExpense(expense);
    }

    private void setOtherExpense() {
        double expense = UserModel.getOtherExpense(startDate, endDate);
        view.setOtherExpense(expense);
    }

    private void setTotalExpense() {
        double expense = UserModel.getTotalExpense(startDate, endDate);
        view.setTotalExpense(expense);
    }

}
