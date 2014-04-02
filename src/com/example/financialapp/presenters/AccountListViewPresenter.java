package com.example.financialapp.presenters;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.financialapp.R;
import com.example.financialapp.activities.AccountActivity;
import com.example.financialapp.models.Account;
import com.example.financialapp.models.AccountModel;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.AccountListView;
import com.example.financialapp.views.ClickListener;

public class AccountListViewPresenter implements ClickListener {
	private AccountListView view;
	private ListActivity activity;
	private List<Account> accounts;

	public AccountListViewPresenter(AccountListView v, ListActivity a) {
		view = v;
		view.linkNotifyCallback(this);
		activity = a;

		AccountModel model = UserModel.getCurrentUser().getAccountModel();
		accounts = model.getAccounts(UserModel.getCurrentUser());
		prepareList();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	private void prepareList() {
		AccountModel model = UserModel.getCurrentUser().getAccountModel();
		List<Account> accounts = model.getAccounts(UserModel.getCurrentUser());
		List<String> names = new ArrayList<String>();
		for (Account a : accounts) {
			names.add(a.getName());
		}
		activity.setListAdapter(new ArrayAdapter<String>(activity,
				R.layout.activity_account_list, names));

		ListView listView = activity.getListView();
		listView.setTextFilterEnabled(true);

		listView.setOnItemClickListener(new AccountClickListener());
	}

	private class AccountClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			UserModel.getCurrentUser().getAccountModel()
					.setCurrentAccount(accounts.get(position));
			Intent intent = new Intent(activity, AccountActivity.class);
			activity.startActivity(intent);
		}
	}
}
