package com.example.financialapp.views;

import com.example.financialapp.models.User;

public interface DashboardView extends CustomView {
	public void setCurrentUser(User user);
}
