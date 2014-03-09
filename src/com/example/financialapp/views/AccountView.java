package com.example.financialapp.views;

public interface AccountView extends CustomView {
	public void setBalance(double balance);
	public double getBalance();
	public void setAccountName();
}
