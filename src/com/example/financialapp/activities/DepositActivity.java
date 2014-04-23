package com.example.financialapp.activities;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.financialapp.R;
import com.example.financialapp.presenters.DepositViewPresenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import com.example.financialapp.views.DepositView;

/**
 * Opens deposit view in app.
 *
 * @author Vishal Erabelli
 *
 */

public class DepositActivity extends MVPActivity implements DepositView {

	/**
	 * presenter handles all operations within the view.
	 */

	private DepositViewPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deposit);

		presenter = new DepositViewPresenter(this, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it
		// is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public double getAmount() {
		EditText amountForm =
			(EditText) findViewById(R.id.deposit_amount);
		double amount;
		try {
			amount = Double.parseDouble(
				amountForm.getText().toString());
		} catch (NumberFormatException e) {
			amount = -1;
		}
		return amount;
	}

	@Override
	public String getDescription() {
		EditText description =
			(EditText) findViewById(R.id.deposit_description);
		return description.getText().toString();
	}
	
	
	@Override
	public String getMonth() {
	    EditText month = (EditText) findViewById(R.id.deposit_EditText_month);
	    return month.getText().toString();
	}
	
	@Override
	public String getDay() {
	    EditText day = (EditText) findViewById(R.id.deposit_EditText_day);
	    return day.getText().toString();
	}
	
	@Override
	public String getYear() {
	    EditText year = (EditText) findViewById(R.id.deposit_EditText_year);
	    return year.getText().toString();
	}
	
	@Override
	public Date getUserDate() {
        String date = this.getMonth() + "/" + this.getDay() + "/" + this.getYear();
        Date userDate;
        try {
            userDate = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            return null;
        }
        return userDate;
    }
	
	@Override
	public String getUserDateString() {
	    String date = this.getMonth() + "/" + this.getDay() + "/" + this.getYear();
	    return date;
	}

	@Override
	public String getCategory() {
		RadioGroup categoryGroup =
			(RadioGroup) findViewById(
				R.id.deposit_RadioGroup_categories);
		int selectedId = categoryGroup.getCheckedRadioButtonId();
		RadioButton categoryButton =
			(RadioButton) findViewById(selectedId);
		return categoryButton.getText().toString();
	}

}
