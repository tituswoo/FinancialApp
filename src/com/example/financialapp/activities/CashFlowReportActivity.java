package com.example.financialapp.activities;

import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import java.text.DateFormat;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.financialapp.R;
import com.example.financialapp.presenters.CashFlowViewPresenter;
import com.example.financialapp.views.CashFlowView;
import com.example.financialapp.views.ClickListener;

public class CashFlowReportActivity extends MVPActivity implements CashFlowView {

    private CashFlowViewPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_flow_report);
        presenter = new CashFlowViewPresenter(this, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cash_flow_report, menu);
        return true;
    }

    @Override
    public void setIncome(double amount) {
        TextView incomeView = (TextView) findViewById(R.id.cashflow_income);
        incomeView.setText("Income: $" + amount);
    }

    @Override
    public void setExpenses(double amount) {
        TextView expensesView = (TextView) findViewById(R.id.cashflow_expenses);
        expensesView.setText("Expenses: $" + amount);
    }

    @Override
    public void setFlow(double amount) {
        TextView flowView = (TextView) findViewById(R.id.cashflow_flow);
        flowView.setText("Flow: $" + amount);
    }

    @Override
    public Date getStartDate() {
        DatePicker startDate = (DatePicker) findViewById(R.id.startDate);
        return new Date(startDate.getCalendarView().getDate());
    }

    @Override
    public Date getEndDate() {
        DatePicker endDate = (DatePicker) findViewById(R.id.endDate);
        return new Date(endDate.getCalendarView().getDate());
    }

    @Override
    public void setDateRange(Date start, Date end) {
        TextView dateRange = (TextView) findViewById(R.id.cashflow_date_range);
        DateFormat dateFormatter = DateFormat.getDateInstance(
                DateFormat.DEFAULT, Locale.US);
        ;
        String startDate = dateFormatter.format(getStartDate());
        String endDate = dateFormatter.format(getEndDate());
        dateRange.setText(startDate + " to " + endDate);
    }

}
