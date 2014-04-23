package com.example.financialapp.activities;

import java.util.Date;
import java.util.Locale;

import android.os.Bundle;
import java.text.DateFormat;
import android.view.Menu;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.financialapp.R;
import com.example.financialapp.presenters.UserDateSetterViewPresenter;
import com.example.financialapp.views.UserDateSetterView;
/**
 * Opens Income Source report view in app.
 *
 * @author Sam Chai
 *
 */

public class UserDateSetterActivity extends MVPActivity implements
        UserDateSetterView {

    /**
     * presenter handles all operations within the view.
     */

    private UserDateSetterViewPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_date_setter);
        presenter = new UserDateSetterViewPresenter(this, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it
        // is present.
        getMenuInflater().inflate(R.menu.user_date_setter, menu);
        return true;
    }

    @Override
    public Date getStartDate() {
        DatePicker startDate =
            (DatePicker) findViewById(
                R.id.userDateSetter_DatePicker_startDate);
        return new Date(startDate.getCalendarView().getDate());
    }

    @Override
    public Date getEndDate() {
        DatePicker endDate =
            (DatePicker) findViewById(
                R.id.userDateSetter_DatePicker_endDate);
        return new Date(endDate.getCalendarView().getDate());
    }

}
