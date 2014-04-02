package com.example.financialapp.activities;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.financialapp.R;
import com.example.financialapp.presenters.DepositViewPresenter;
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
