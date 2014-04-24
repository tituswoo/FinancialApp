package com.example.financialapp.activities;

import java.util.Date;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;

import com.example.financialapp.models.UserModel;
import com.example.financialapp.presenters.TransactionHistoryViewPresenter;
import com.example.financialapp.views.TransactionHistoryView;
import com.example.financialapp.views.ClickListener;

/**
 * Opens a list of all accounts a user has.
 *
 * @author Vishal Erabelli
 */

public class TransactionHistoryActivity extends ListActivity implements
        TransactionHistoryView {

    /**
     * presenter handles operations in the view.
     */
    private TransactionHistoryViewPresenter presenter;
    /**
     * aListener handles any buttons tapped in the view.
     */
    private ClickListener aListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new TransactionHistoryViewPresenter(this, this);
    }

    @Override
    public void linkNotifyCallback(ClickListener listener) {
        this.aListener = listener;
    }

    @Override
    public void onBtnClick(View v) {
        // TODO Auto-generated method stub

    }
    
}
