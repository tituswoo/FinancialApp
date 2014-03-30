package com.example.financialapp.views;

import java.util.Date;

public interface IncomeSourceView extends CustomView{
    public void setDateRange(Date start, Date end);
    public Date getStartDate();
    public Date getEndDate();
    public void setSalary(double amount);
    public void setBirthday(double amount);
    public void setParents(double amount);
    public void setScholarship(double amount);
    public void setOther(double amount);
    public void setTotal(double amount);
}
