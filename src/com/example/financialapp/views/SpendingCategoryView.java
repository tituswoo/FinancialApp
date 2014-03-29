package com.example.financialapp.views;

import java.util.Date;

public interface SpendingCategoryView extends CustomView {
	public void setDateRange(Date start, Date end);
	public Date getStartDate();
	public Date getEndDate();
	public void setFoodExpense(double amount);
	public void setRentExpense(double amount);
	public void setEntertainmentExpense(double amount);
	public void setClothingExpense(double amount);
	public void setOtherExpense(double amount);
	public void setTotalExpense(double amount);
}
