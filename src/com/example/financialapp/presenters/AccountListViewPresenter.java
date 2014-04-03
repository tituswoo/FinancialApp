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

/**.
 * Presenter for viewing existing accounts
 * 
 * @author Samuel
 *
 */
public class AccountListViewPresenter implements ClickListener {
    
    /**
     * View for UI elements.
     */
    private AccountListView view;
    
    /**
     * Activity for holding the list of accounts.
     */
    private ListActivity activity;
    
    /**
     * A list of accounts.
     */
    private List<Account> accounts;

    /**
     * This constructor gets references to the AccountListView and the main activity
     * it's from (so that it can launch intents).
     * 
     * @param v
     *            The view.
     * @param a
     *            The activity (for launching intents).
     */
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

    /**
     * Gets the accounts from the user and displays them.
     */
    private void prepareList() {
        AccountModel model = UserModel.getCurrentUser().getAccountModel();
        List<Account> accountList = model.getAccounts(UserModel.getCurrentUser());
        List<String> names = new ArrayList<String>();
        for (Account a : accountList) {
            names.add(a.getName());
        }
        activity.setListAdapter(new ArrayAdapter<String>(activity,
                R.layout.activity_account_list, names));

        ListView listView = activity.getListView();
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AccountClickListener());
    }

    /**
     * ClickListener specific for Account List to display a dynamic list.
     * 
     * @author Samuel
     *
     */
    private class AccountClickListener implements OnItemClickListener {
        
        @Override
        public void onItemClick(AdapterView<?> parent, View views, int position,
                long id) {
            UserModel.getCurrentUser().getAccountModel()
                    .setCurrentAccount(accounts.get(position));
            Intent intent = new Intent(activity, AccountActivity.class);
            activity.startActivity(intent);
        }
    }
}
