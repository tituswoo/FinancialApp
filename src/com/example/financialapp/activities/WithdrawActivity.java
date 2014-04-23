package com.example.financialapp.activities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.financialapp.R;
import com.example.financialapp.presenters.WithdrawViewPresenter;
import com.example.financialapp.views.WithdrawView;

/**
 * Opens the view to allow a user to withdraw money.
 * @author Vishal Erabelli
 */

public class WithdrawActivity extends MVPActivity implements WithdrawView {

	/**
	 * presenter handles all operations within the view.
	 */

	private WithdrawViewPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_withdraw);

		presenter = new WithdrawViewPresenter(this, this);
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
			(EditText) findViewById(R.id.withdraw_amount);
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
			(EditText) findViewById(R.id.withdraw_description);
		return description.getText().toString();
	}

	@Override
	public String getCategory() {
		RadioGroup categoryGroup =
			(RadioGroup) findViewById(
				R.id.withdraw_radioGroup_categories);
		int selected = categoryGroup.getCheckedRadioButtonId();
		RadioButton category = (RadioButton) findViewById(selected);
		return category.getText().toString();
	}

   @Override
    public String getMonth() {
        EditText month = (EditText) findViewById(R.id.withdraw_EditText_month);
        return month.getText().toString();
    }
    
    @Override
    public String getDay() {
        EditText day = (EditText) findViewById(R.id.withdraw_EditText_day);
        return day.getText().toString();
    }
    
    @Override
    public String getYear() {
        EditText year = (EditText) findViewById(R.id.withdraw_EditText_year);
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
}
