package com.example.financialapp.presenters;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.financialapp.R;
import com.example.financialapp.activities.AccountListActivity;
import com.example.financialapp.activities.CashFlowReportActivity;
import com.example.financialapp.activities.CreateAccountActivity;
import com.example.financialapp.activities.NetworkTestActivity;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.DashboardView;

public class DashboardViewPresenter implements ClickListener {
	
	private DashboardView view;
	private Activity activity;
	
	public DashboardViewPresenter(DashboardView v, Activity a) {
		view = v;
		view.linkNotifyCallback(this);
		activity = a;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.new_account:
			launchCreateAccountActivity();
			Log.i("Taps", "New Account button tapped.");
			break;
		case R.id.view_accounts:
			launchAccountListActivity();
			Log.i("Taps", "View Accounts button tapped.");
			break;
		case R.id.cashFlowReportActivity:
			launchCashFlowReportActivity();
			break;
		default:
			Log.i("Warning", "Something weird happened.");
		}
	}
	
	private void launchCreateAccountActivity() {
		activity.startActivity(new Intent(activity, CreateAccountActivity.class));
	}
	private void launchNetworkTestActivity() {
		activity.startActivity(new Intent(activity, NetworkTestActivity.class));
	}
	private void launchAccountListActivity() {
		activity.startActivity(new Intent(activity, AccountListActivity.class));
	}
	private void launchCashFlowReportActivity() {
		activity.startActivity(new Intent(activity, CashFlowReportActivity.class));
	}

}