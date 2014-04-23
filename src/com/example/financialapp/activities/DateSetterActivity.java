package com.example.financialapp.activities;

import java.util.Date;
import java.util.Locale;

import android.os.Bundle;
import java.text.DateFormat;
import android.view.Menu;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.financialapp.R;
import com.example.financialapp.presenters.DateSetterViewPresenter;
import com.example.financialapp.views.DateSetterView;

/**
 * Opens Income Source report view in app.
 *
 * @author Sam Chai
 *
 */

public class DateSetterActivity extends MVPActivity implements
        DateSetterView {

    /**
     * presenter handles all operations within the view.
     */

    private DateSetterViewPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_setter);
        presenter = new DateSetterViewPresenter(this, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it
        // is present.
        getMenuInflater().inflate(R.menu.date_setter, menu);
        return true;
    }

    @Override
    public Date getStartDate() {
        DatePicker startDate =
            (DatePicker) findViewById(
                R.id.dateSetter_DatePicker_startDate);
        return new Date(startDate.getCalendarView().getDate());
    }

    @Override
    public Date getEndDate() {
        DatePicker endDate =
            (DatePicker) findViewById(
                R.id.dateSetter_DatePicker_endDate);
        return new Date(endDate.getCalendarView().getDate());
    }

}
