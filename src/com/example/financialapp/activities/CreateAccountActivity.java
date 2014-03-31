package com.example.financialapp.activities;

import com.example.financialapp.R;
import com.example.financialapp.R.layout;
import com.example.financialapp.R.menu;
import com.example.financialapp.presenters.CreateAccountViewPresenter;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.CreateAccountView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class CreateAccountActivity extends MVPActivity implements
        CreateAccountView {

    CreateAccountViewPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        presenter = new CreateAccountViewPresenter(this, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_account, menu);
        return true;
    }

    public String getAccountName() {
        EditText editText = (EditText) findViewById(R.id.accountName_editText1);
        return editText.getText().toString();
    }

}
