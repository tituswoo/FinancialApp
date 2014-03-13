package com.example.financialapp.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.financialapp.presenters.AccountListViewPresenter;
import com.example.financialapp.views.AccountListView;
import com.example.financialapp.views.ClickListener;

public class AccountListActivity extends ListActivity implements AccountListView {

	private AccountListViewPresenter presenter;
	private ClickListener listener;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		presenter = new AccountListViewPresenter(this, this);
	}
	
	@Override
	public void linkNotifyCallback(ClickListener listener) {
		this.listener = listener;
	}

	@Override
	public void onBtnClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
