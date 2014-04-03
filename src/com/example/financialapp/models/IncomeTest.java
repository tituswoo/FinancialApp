package com.example.financialapp.models;

import java.util.Date;

import junit.framework.TestCase;

public class IncomeTest extends TestCase {
	
	public void testEmpty() {
		Account account = new Account("Test");
		assertTrue("Empty account has none zero income.", account.getIncome(null, null) == 0.0);
	}
	
	
	public void testEmptyWithDates() {
		Account account = new Account("Test");
		Date start = new Date();
		for (int i = 0; i < 100; i++);
		Date end = new Date();
		assertTrue("Empty account has none zero income.", account.getIncome(start, end) == 0.0);
	}
	
	public void testEmptyWithReversedDates() {
		Account account = new Account("Test");
		Date start = new Date();
		for (int i = 0; i < 100; i++);
		Date end = new Date();
		account.getIncome(end, start);
	}
		
	public void testAddInvalidDeposit() {
		Account account = new Account("Test");
		account.add(new Deposit(-100.0, "Invalid Deposit", "Test"));
	}
	
	public void testIncomeWithDeposits() {
		Account account = new Account("Test");

		account.add(new Deposit(100.00, "Test Deposit 1", "Test"));
		account.add(new Deposit(50.00, "Test Deposit 2", "Test"));
		account.add(new Deposit(25.00, "Test Deposit 2", "Test"));
		account.add(new Deposit(12.50, "Test Deposit 3", "Test"));
		
		assertTrue("Account income doesn't match expected amount.", account.getIncome(null, null) == 187.50);
	}
	
	public void testIncomeWithinDatesOnlyDeposits() {
		Account account = new Account("Test");
		Date start = new Date();
		
		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 100; i++);

		account.add(new Deposit(100.00, "Test Deposit 1", "Test"));
		account.add(new Deposit(50.00, "Test Deposit 2", "Test"));
		account.add(new Deposit(25.00, "Test Deposit 2", "Test"));
		account.add(new Deposit(12.50, "Test Deposit 3", "Test"));
		
		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 100; i++);
		
		Date end = new Date();
		assertTrue("Account income doesn't match expected amount.", account.getIncome(start, end) == 187.50);
	}

	public void testIncomeOnlyDeposits() {
		Account account = new Account("Test");
		

		account.add(new Deposit(100.00, "Test Deposit 1", "Test"));

		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 100; i++);
		
		Date start = new Date();
		
		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 100; i++);

		account.add(new Deposit(100.00, "Test Deposit 2", "Test"));
		account.add(new Deposit(50.00, "Test Deposit 3", "Test"));
		account.add(new Deposit(25.00, "Test Deposit 4", "Test"));
		account.add(new Deposit(12.50, "Test Deposit 5", "Test"));
		
		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 100; i++);
		
		Date end = new Date();
		
		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 100; i++);
		
		account.add(new Deposit(12.50, "Test Deposit 6", "Test"));
		
		
		assertTrue("Account income doesn't match expected amount.", account.getIncome(start, end) == 187.50);
	}

	public void testIncomeDepositsAndWithdrawals() {
		Account account = new Account("Test");
		

		account.add(new Deposit(100.00, "Test Deposit 1", "Test"));
		account.add(new Withdrawal(-100.0, "Test Withdrawal 1", "Test"));
		
		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 100; i++);
		
		Date start = new Date();
		
		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 100; i++);

		account.add(new Deposit(100.00, "Test Deposit 2", "Test"));
		account.add(new Withdrawal(-100.0, "Test Withdrawal 2", "Test"));
		account.add(new Deposit(50.00, "Test Deposit 3", "Test"));
		account.add(new Deposit(25.00, "Test Deposit 4", "Test"));
		account.add(new Deposit(12.50, "Test Deposit 5", "Test"));
		
		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 100; i++);
		
		Date end = new Date();
		
		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 100; i++);
		
		account.add(new Deposit(12.50, "Test Deposit 6", "Test"));
		account.add(new Withdrawal(-12.50, "Test Withdrawal 3", "Test"));
		
		
		assertTrue("Account income doesn't match expected amount.", account.getIncome(start, end) == 187.50);
	}
}
