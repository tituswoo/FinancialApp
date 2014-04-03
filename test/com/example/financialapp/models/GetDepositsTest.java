package com.example.financialapp.models;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class GetDepositsTest {

    // Null start means no start date.
    @Test
    public void testStartEndNull() {
        //Create account with transaction history.
        Account accountTester = new Account("test");
        TransactionModel history = new SimpleTransactionModel();
        
        //set start date and end date.
        Date startDate = null;
        Date endDate = null;
        
        //insert deposit with date. Add it to the account's history.
        Deposit deposit1 = new Deposit(50, "", "");
        Date depositDate = new Date(1);
        deposit1.setDate(depositDate);
        history.add(deposit1);
        accountTester.setHistory(history);
        ArrayList<Deposit> result = new ArrayList<Deposit>();
        result.add(deposit1);
        //Should have one deposit.
        Assert.assertEquals("No start date and no end date with deposit",
                result, accountTester.getDeposits(startDate, endDate));
    }
    
	// Null start means no start date.
    @Test
    public void testStartNull() {
        //Create account with transaction history.
        Account accountTester = new Account("test");
        TransactionModel history = new SimpleTransactionModel();
        
        //set start date and end date.
        Date startDate = null;
        Date endDate = new Date(2);
        
        //insert deposit with date. Add it to the account's history.
        Deposit deposit1 = new Deposit(50, "", "");
        Date depositDate = new Date(1);
        deposit1.setDate(depositDate);
        history.add(deposit1);
        accountTester.setHistory(history);
        ArrayList<Deposit> result = new ArrayList<Deposit>();
        result.add(deposit1);
        //Should have one deposit.
        Assert.assertEquals("No start date but deposit date before end date",
				result, accountTester.getDeposits(startDate, endDate));
        endDate.setTime(1);
        //Should have one deposit.
        Assert.assertEquals("No start date but deposit date equals end date",
				result, accountTester.getDeposits(startDate, endDate));
        endDate.setTime(0);
        result.remove(0);
        //Should have no deposits.
        Assert.assertEquals("No start date but deposit date after end date",
				result, accountTester.getDeposits(startDate, endDate));
    }

    @Test
    public void testEndNull() {
        //Create account with transaction history.
        Account accountTester = new Account("test");
        TransactionModel history = new SimpleTransactionModel();
        
        //set start date and end date.
        Date startDate = new Date(2);
        Date endDate = null;
        
        //insert deposit with date. Add it to the account's history.
        Deposit deposit1 = new Deposit(50, "", "");
        Date depositDate = new Date(1);
        deposit1.setDate(depositDate);
        history.add(deposit1);
        accountTester.setHistory(history);
        ArrayList<Deposit> result = new ArrayList<Deposit>();
        //Should have no deposits.
        Assert.assertEquals("No end date but deposit date before start date",
				result, accountTester.getDeposits(startDate, endDate));
        startDate.setTime(1);
        result.add(deposit1);
        //Should have one deposit.
        Assert.assertEquals("No end date but deposit date equals start date",
				result, accountTester.getDeposits(startDate, endDate));
        startDate.setTime(0);
        //Should have one deposit.
        Assert.assertEquals("No end date but deposit date after start date",
				result, accountTester.getDeposits(startDate, endDate));
    }

    @Test
    public void testStartEndNotNull() {
        //Create account with transaction history.
        Account accountTester = new Account("test");
        TransactionModel history = new SimpleTransactionModel();
        
        //set start date and end date.
        Date startDate = new Date(3);
        Date endDate = new Date(6);
		
		//insert deposit with date. Add it to the account's history.
        Deposit deposit1 = new Deposit(50, "", "");
        Date depositDate = new Date(2);
        deposit1.setDate(depositDate);
        history.add(deposit1);
        accountTester.setHistory(history);
        ArrayList<Deposit> result = new ArrayList<Deposit>();
		//Should have no deposits.
        Assert.assertEquals("Deposit date before start date", result,
				accountTester.getDeposits(startDate, endDate));
		//Should have no deposits.
        Assert.assertEquals("Deposit date greater than end date", result,
				accountTester.getDeposits(startDate, endDate));
        result.add(deposit1);
        startDate.setTime(2);
		//Should have one deposit.
        Assert.assertEquals("Deposit date equals start date", result,
				accountTester.getDeposits(startDate, endDate));
        startDate.setTime(1);
		//Should have one deposit.
        Assert.assertEquals(
				"Deposit date is greater than start date but less than end date",
				result, accountTester.getDeposits(startDate, endDate));
        endDate.setTime(2);
		//Should have one deposit.
        Assert.assertEquals("Deposit date equals end date", result,
				accountTester.getDeposits(startDate, endDate));
    }

}
