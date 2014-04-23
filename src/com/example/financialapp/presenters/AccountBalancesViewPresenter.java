package com.example.financialapp.presenters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.financialapp.R;
import com.example.financialapp.activities.TransactionHistoryActivity;
import com.example.financialapp.models.Account;
import com.example.financialapp.models.AccountModel;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.AccountBalancesView;
import com.example.financialapp.views.ClickListener;

/**.
 * Presenter for viewing existing accounts
 * 
 * @author Samuel
 *
 */
public class AccountBalancesViewPresenter implements ClickListener {
    
    /**
     * View for UI elements.
     */
    private AccountBalancesView view;
    
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
    public AccountBalancesViewPresenter(AccountBalancesView v, ListActivity a) {
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
        DateFormat df = new SimpleDateFormat("MMMM dd, yyyy");
        Date startDate = UserModel.getCurrentUser().getStartDate();
        Date endDate = UserModel.getCurrentUser().getEndDate();
        String stringStart = df.format(startDate);
        String stringEnd = df.format(endDate);
        String dateRange = "Date range is from " + stringStart + " to " + stringEnd;
        names.add(dateRange);
        for (Account a : accountList) {
            String balance = String.valueOf(a.getBalance(startDate,endDate));
            names.add(a.getName() + ": Balance = " + balance);
        }
        activity.setListAdapter(new ArrayAdapter<String>(activity,
                R.layout.activity_account_balances, names));

        ListView listView = activity.getListView();
        listView.setTextFilterEnabled(true);
        listView.setOnItemClickListener(new AccountBalancesClickListener());
    }

    /**
     * ClickListener specific for Account List to display a dynamic list.
     * 
     * @author Samuel
     *
     */
    private class AccountBalancesClickListener implements OnItemClickListener {
        
        @Override
        public void onItemClick(AdapterView<?> parent, View views,final int position,
                long id) {
            new AlertDialog.Builder(activity).setTitle("Go to transaction history for this account?")
            .setNeutralButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(
                        DialogInterface dialog,
                        int which) {
                    UserModel.getCurrentUser().getAccountModel()
                    .setCurrentAccount(accounts.get(position));
                    Intent intent = new Intent(activity, TransactionHistoryActivity.class);
                    activity.startActivity(intent);
                }
            }).setPositiveButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(
                        DialogInterface dialog,
                        int which) {
                    
                }
            }).show();
        }
    }
}
