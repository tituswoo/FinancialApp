package com.example.financialapp.activities;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import com.example.financialapp.R;
import com.example.financialapp.R.layout;
import com.example.financialapp.R.menu;
import com.example.financialapp.presenters.SpendingCategoryViewPresenter;
import com.example.financialapp.views.SpendingCategoryView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.DatePicker;
import android.widget.TextView;

public class SpendingCategoryReportActivity extends MVPActivity implements
        SpendingCategoryView {

    private SpendingCategoryViewPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending_category_report);
        presenter = new SpendingCategoryViewPresenter(this, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.spending_category_report, menu);
        return true;
    }

    @Override
    public void setDateRange(Date start, Date end) {
        TextView dateRange = (TextView) findViewById(R.id.spendingCategory_date_range);
        DateFormat dateFormatter = DateFormat.getDateInstance(
                DateFormat.DEFAULT, Locale.US);
        ;
        String startDate = dateFormatter.format(getStartDate());
        String endDate = dateFormatter.format(getEndDate());
        dateRange.setText(startDate + " to " + endDate);
    }

    @Override
    public Date getStartDate() {
        DatePicker startDate = (DatePicker) findViewById(R.id.spendingCategory_startDate);
        return new Date(startDate.getCalendarView().getDate());
    }

    @Override
    public Date getEndDate() {
        DatePicker endDate = (DatePicker) findViewById(R.id.spendingCategory_endDate);
        return new Date(endDate.getCalendarView().getDate());
    }

    @Override
    public void setFoodExpense(double amount) {
        TextView foodExpenseView = (TextView) findViewById(R.id.spendingCategory_food);
        foodExpenseView.setText("Food: $" + amount);
    }

    @Override
    public void setRentExpense(double amount) {
        TextView rentExpenseView = (TextView) findViewById(R.id.spendingCategory_rent_expenses);
        rentExpenseView.setText("Rent/Expenses: $" + amount);
    }

    @Override
    public void setEntertainmentExpense(double amount) {
        TextView entertainmentExpenseView = (TextView) findViewById(R.id.spendingCategory_entertainment);
        entertainmentExpenseView.setText("Entertainment: $" + amount);
    }

    @Override
    public void setClothingExpense(double amount) {
        TextView clothingExpenseView = (TextView) findViewById(R.id.spendingCategory_clothing);
        clothingExpenseView.setText("Clothing: $" + amount);
    }

    @Override
    public void setOtherExpense(double amount) {
        TextView otherExpenseView = (TextView) findViewById(R.id.spendingCategory_other);
        otherExpenseView.setText("Other: $" + amount);
    }

    @Override
    public void setTotalExpense(double amount) {
        TextView totalExpenseView = (TextView) findViewById(R.id.spendingCategory_total);
        totalExpenseView.setText("Total: $" + amount);
    }

}
