package com.example.financialapp.views;

import java.util.Date;

public interface CashFlowView extends CustomView {
	public void setDateRange(Date start, Date end);

	public Date getStartDate();

	public Date getEndDate();

	public void setIncome(double amount);

	public void setExpenses(double amount);

	public void setFlow(double amount);
}
