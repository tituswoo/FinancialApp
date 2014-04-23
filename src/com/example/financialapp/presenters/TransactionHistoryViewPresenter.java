package com.example.financialapp.presenters;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import com.example.financialapp.activities.AccountActivity;
import com.example.financialapp.models.Account;
import com.example.financialapp.models.AccountModel;
import com.example.financialapp.models.Transaction;
import com.example.financialapp.models.UserModel;
import com.example.financialapp.views.TransactionHistoryView;
import com.example.financialapp.views.ClickListener;

/**.
 * Presenter for viewing existing accounts
 * 
 * @author Samuel
 *
 */
public class TransactionHistoryViewPresenter implements ClickListener {
    
    /**
     * View for UI elements.
     */
    private TransactionHistoryView view;
    
    /**
     * Activity for holding the list of accounts.
     */
    private ListActivity activity;
    
    /**
     * A list of accounts.
     */
    private List<Transaction> transactionList;

    /**
     * This constructor gets references to the TransactionHistoryView and the main activity
     * it's from (so that it can launch intents).
     * 
     * @param v
     *            The view.
     * @param a
     *            The activity (for launching intents).
     */
    public TransactionHistoryViewPresenter(TransactionHistoryView v, ListActivity a) {
        view = v;
        view.linkNotifyCallback(this);
        activity = a;
        Date startDate = UserModel.getCurrentUser().getStartDate();
        Date endDate = UserModel.getCurrentUser().getEndDate();
        transactionList = UserModel.getCurrentUser().getAccountModel().getCurrentAccount().getHistory().getTransactionHistory(startDate, endDate);
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
        List<String> transactions = new ArrayList<String>();
        for (Transaction t : transactionList) {
            transactions.add(t.getUserDateString() + ", " + t.getType() + ", " + t.getCategory() + ", " + String.valueOf(t.getAmount() + ", " + t.getStatus()));
        }
        activity.setListAdapter(new ArrayAdapter<String>(activity,
                R.layout.activity_transaction_history, transactions));

        ListView listView = activity.getListView();
        listView.setTextFilterEnabled(true);
        listView.setOnItemClickListener(new TransactionHistoryClickListener());
    }

    /**
     * ClickListener specific for Account List to display a dynamic list.
     * 
     * @author Samuel
     *
     */
    private class TransactionHistoryClickListener implements OnItemClickListener {
        
        @Override
        public void onItemClick(AdapterView<?> parent, View views, final int position,
                long id) {
            new AlertDialog.Builder(activity).setTitle("Commit or Rollback?")
            .setNeutralButton("Commit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(
                        DialogInterface dialog,
                        int which) {
                    Transaction t = transactionList.get(position);
                    if (!t.getStatus().equals("Committed")) {
                        t.setStatus("Committed");
                        t.setAmount(t.getAmount() * -1);
                    }
                    activity.recreate();
                }
            })
            .setPositiveButton("Rollback", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(
                        DialogInterface dialog,
                        int which) {
                    Transaction t = transactionList.get(position);
                    if (!t.getStatus().equals("Rollbacked")) {
                        t.setStatus("Rollbacked");
                        t.setAmount(t.getAmount() * -1);
                    }
                    activity.recreate();
                }
            }).show();
        }
    }
}
