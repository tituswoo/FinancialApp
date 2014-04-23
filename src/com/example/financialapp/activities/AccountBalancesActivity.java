package com.example.financialapp.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import com.example.financialapp.presenters.AccountBalancesViewPresenter;
import com.example.financialapp.views.AccountBalancesView;
import com.example.financialapp.views.ClickListener;

/**
 * Opens a list of all accounts a user has.
 *
 * @author Vishal Erabelli
 */

public class AccountBalancesActivity extends ListActivity implements
        AccountBalancesView {

    /**
     * presenter handles operations in the view.
     */
    private AccountBalancesViewPresenter presenter;
    /**
     * aListener handles any buttons tapped in the view.
     */
    private ClickListener aListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AccountBalancesViewPresenter(this, this);
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
