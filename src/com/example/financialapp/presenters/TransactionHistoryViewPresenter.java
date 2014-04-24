package com.example.financialapp.presenters;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
        prepareList(startDate, endDate);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

    }

    /**
     * Gets the accounts from the user and displays them.
     */
    public void prepareList(Date startDate, Date endDate) {
        List<String> transactions = new ArrayList<String>();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String stringStart = df.format(startDate);
        String stringEnd = df.format(endDate);
        String dateRange = stringStart + " to " + stringEnd;
        Double balance = UserModel.getCurrentUser().getAccountModel().getCurrentAccount().getBalance(startDate, endDate);
        DecimalFormat dcf = new DecimalFormat("#0.00");
        transactions.add(dateRange + "\nTotal Balance: $" + dcf.format(balance));
        for (Transaction t : transactionList) {
            
            if (t.getStatus().equals("Rollbacked")) {
                transactions.add(t.getUserDateString() + " | " + t.getType() + " | " + t.getCategory() + " | Amount: $" + dcf.format(t.getRollback()) + " | " + t.getStatus());
            } else {
                transactions.add(t.getUserDateString() + " | " + t.getType() + " | " + t.getCategory() + " | Amount: $" + dcf.format(t.getAmount()) + " | " + t.getStatus());
            }
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
            if (position!=0) {
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                String date = df.format(transactionList.get(position-1).getDate());
                new AlertDialog.Builder(activity).setTitle("Commit or Rollback?")
                .setMessage("Date Entered: " + date + "\nDescription: " + transactionList.get(position-1).getDescription())
                .setNeutralButton("Commit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(
                            DialogInterface dialog,
                            int which) {
                        Transaction t = transactionList.get(position-1);
                        if (t.getStatus().equals("Rollbacked")) {
                            t.setStatus("Committed");
                            t.setAmount(t.getRollback());
                        }
                        activity.recreate();
                    }
                })
                .setPositiveButton("Rollback", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(
                            DialogInterface dialog,
                            int which) {
                        Transaction t = transactionList.get(position-1);
                        if (t.getStatus().equals("Committed")) {
                            t.setStatus("Rollbacked");
                            t.setRollback(t.getAmount());
                            t.setAmount(0);
                        }
                        activity.recreate();
                    }
                }).show();
            }
        }
    }
}
