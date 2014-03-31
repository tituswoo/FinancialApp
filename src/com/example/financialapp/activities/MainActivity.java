package com.example.financialapp.activities;

import com.example.financialapp.R;
import com.example.financialapp.R.layout;
import com.example.financialapp.R.menu;
import com.example.financialapp.database.FileReadWriteTest;
import com.example.financialapp.presenters.WelcomeViewPresenter;
import com.example.financialapp.views.ClickListener;
import com.example.financialapp.views.WelcomeView;

import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends MVPActivity implements WelcomeView {

	WelcomeViewPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		presenter = new WelcomeViewPresenter(this, this);
		
		//Quick test to try and save a file:
		FileReadWriteTest testFileWriter = new FileReadWriteTest(this);
		testFileWriter.save();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
