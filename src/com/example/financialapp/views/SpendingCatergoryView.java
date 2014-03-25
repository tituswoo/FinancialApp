package com.example.financialapp.views;

import java.util.Date;

public interface SpendingCatergoryView extends CustomView {
	public void setDateRange(Date start, Date end);
	public Date getStartDate();
	public Date getEndDate();
	
}
