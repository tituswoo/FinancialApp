package com.example.financialapp.presenters;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.financialapp.R;
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
		switch (v.getId()) {
		default:
			Log.i("Warning", "Something weird happened.");
		}
	}

}
