package com.example.financialapp.presenters;

import java.util.Date;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.example.financialapp.R;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.SpendingCategoryView;

/**
 * Presenter for the spending category report screen.
 * 
 * @author Samuel
 *
 */
public class SpendingCategoryViewPresenter implements ClickListener {

    /**
     * View for UI elements.
     */
    private SpendingCategoryView view;
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
     * This constructor gets references to the SpendingCategoryView and the main activity
     * it's from (so that it can launch intents).
     * 
     * @param v
     *            The view.
     * @param a
     *            The activity (for launching intents).
     */
    public SpendingCategoryViewPresenter(SpendingCategoryView v, Activity a) {
        view = v;
        view.linkNotifyCallback(this);
        activity = a;
    }

    /**
     * Updates the date range and sets the expenses for each category for the date range. Also sets the total expenses.
     */
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

    /**
     * Sets the date range.
     */
    private void setDateRange() {
        view.setDateRange(startDate, endDate);
    }

    /**
     * Sets the food expenses.
     */
    private void setFoodExpense() {
        double expense = UserModel.getFoodExpense(startDate, endDate);
        view.setFoodExpense(expense);
    }

    /**
     * Sets the rent expenses.
     */
    private void setRentExpense() {
        double expense = UserModel.getRentExpense(startDate, endDate);
        view.setRentExpense(expense);
    }

    /**
     * Sets the entertainment expenses.
     */
    private void setEntertainmentExpense() {
        double expense = UserModel.getEntertainmentExpense(startDate, endDate);
        view.setEntertainmentExpense(expense);
    }

    /**
     * Sets the clothing expenses.
     */
    private void setClothingExpense() {
        double expense = UserModel.getClothingExpense(startDate, endDate);
        view.setClothingExpense(expense);
    }

    /**
     * Sets the other expenses.
     */
    private void setOtherExpense() {
        double expense = UserModel.getOtherExpense(startDate, endDate);
        view.setOtherExpense(expense);
    }

    /**
     * Sets the total expenses.
     */
    private void setTotalExpense() {
        double expense = UserModel.getTotalExpense(startDate, endDate);
        view.setTotalExpense(expense);
    }

}
