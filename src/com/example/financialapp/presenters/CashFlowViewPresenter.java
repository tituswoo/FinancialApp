package com.example.financialapp.presenters;

import java.util.Date;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.example.financialapp.R;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.CashFlowView;
import com.example.financialapp.views.ClickListener;

public class CashFlowViewPresenter implements ClickListener {
	private CashFlowView view;
	private Activity activity;
	Date startDate, endDate;

	public CashFlowViewPresenter(CashFlowView v, Activity a) {
		view = v;
		view.linkNotifyCallback(this);
		activity = a;
		update();
	}

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

	private void setDateRange() {
		view.setDateRange(startDate, endDate);
	}

	private void setIncome() {
		double income = UserModel.getIncome(startDate, endDate);
		view.setIncome(income);
	}

	private void setExpenses() {
		double expenses = UserModel.getExpenses(startDate, endDate);
		view.setExpenses(expenses);
	}

	private void setFlow() {
		double flow = UserModel.getIncome(startDate, endDate)
				+ UserModel.getExpenses(startDate, endDate);
		view.setFlow(flow);
	}

}
