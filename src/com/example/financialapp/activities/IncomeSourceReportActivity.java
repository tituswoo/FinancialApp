package com.example.financialapp.activities;

import java.util.Date;
import java.util.Locale;

import android.os.Bundle;
import java.text.DateFormat;
import java.text.DecimalFormat;

import android.view.Menu;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.financialapp.R;
import com.example.financialapp.presenters.IncomeSourceViewPresenter;
import com.example.financialapp.views.IncomeSourceView;

/**
 * Opens Income Source report view in app.
 *
 * @author Sam Chai
 *
 */

public class IncomeSourceReportActivity extends MVPActivity implements
		IncomeSourceView {

	/**
	 * presenter handles all operations within the view.
	 */

	private IncomeSourceViewPresenter presenter;
	
	private DecimalFormat dcf = new DecimalFormat("#0.00");
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_income_source_report);
		presenter = new IncomeSourceViewPresenter(this, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it
		// is present.
		getMenuInflater().inflate(R.menu.income_source_report, menu);
		return true;
	}

	@Override
	public void setSalary(double amount) {
		TextView salaryView =
			(TextView) findViewById(
				R.id.incomeSourceReport_TextView_salary);
		salaryView.setText("Salary: $" + dcf.format(amount));
	}

	@Override
	public void setBirthday(double amount) {
		TextView birthdayView =
			(TextView) findViewById(
				R.id.incomeSourceReport_TextView_birthday);
		birthdayView.setText("Birthday: $" + dcf.format(amount));
	}

	@Override
	public void setParents(double amount) {
		TextView parentsView =
			(TextView) findViewById(
				R.id.incomeSourceReport_TextView_parents);
		parentsView.setText("Parents: $" + dcf.format(amount));
	}

	@Override
	public void setScholarship(double amount) {
		TextView scholarshipView =
			(TextView) findViewById(
				R.id.incomeSourceReport_TextView_scholarship);
		scholarshipView.setText("Scholarship: $" + dcf.format(amount));
	}

	@Override
	public void setOther(double amount) {
		TextView otherView =
			(TextView) findViewById(
				R.id.incomeSourceReport_TextView_other);
		otherView.setText("Other: $" + dcf.format(amount));
	}

	@Override
	public void setTotal(double amount) {
		TextView totalView =
			(TextView) findViewById(
				R.id.incomeSourceReport_TextView_total);
		totalView.setText("Total: $" + dcf.format(amount));
	}

	@Override
	public Date getStartDate() {
		DatePicker startDate =
			(DatePicker) findViewById(
				R.id.incomeSourceReportStartDate);
		return new Date(startDate.getCalendarView().getDate());
	}

	@Override
	public Date getEndDate() {
		DatePicker endDate =
			(DatePicker) findViewById(
				R.id.incomeSourceReportEndDate);
		return new Date(endDate.getCalendarView().getDate());
	}

	@Override
	public void setDateRange(Date start, Date end) {
		TextView dateRange =
			(TextView) findViewById(
				R.id.incomeSourceReport_date_range);
		DateFormat dateFormatter = DateFormat.getDateInstance(
				DateFormat.DEFAULT, Locale.US);
		String startDate = dateFormatter.format(getStartDate());
		String endDate = dateFormatter.format(getEndDate());
		dateRange.setText(startDate + " to " + endDate);
	}

}
