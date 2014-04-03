package com.example.financialapp.models;

import java.util.Date;

import junit.framework.TestCase;

public class IncomeTest extends TestCase {
	
	public void testEmpty() {
		Account account = new Account("Test");
		assertEquals("Empty account has none zero income.", 0.0, account.getIncome(null, null));
	}
	
	
	public void testEmptyWithDates() {
		Account account = new Account("Test");
		Date start = new Date();
		for (int i = 0; i < 10000; i++);
		Date end = new Date();
		assertEquals("Empty account has none zero income.", 0.0, account.getIncome(start, end));
	}
	
	public void testEmptyWithReversedDates() {
		Account account = new Account("Test");
		Date start = new Date();
		for (int i = 0; i < 10000; i++);
		Date end = new Date();
		try {
		    account.getIncome(end, start); 
		    fail("Failed to recognize reversed date.");
		} catch (IllegalArgumentException e) {
		    assertTrue("Found reversed date.", true);
		}
        fail("Failed to recognize reversed date.");
	}
		
	public void testAddInvalidDeposit() {
		Account account = new Account("Test");
        try {
            account.add(new Deposit(-100.0, "Invalid Deposit", "Test"));
            fail("Failed to recognize invalid deposit.");
        } catch (IllegalArgumentException e) {
            assertTrue("Found invalid deposit.", true);
        }
        fail("Failed to recognize invalid deposit.");
	}
	
	public void testIncomeWithDeposits() {
		Account account = new Account("Test");

		account.add(new Deposit(100.00, "Test Deposit 1", "Test"));
		account.add(new Deposit(50.00, "Test Deposit 2", "Test"));
		account.add(new Deposit(25.00, "Test Deposit 2", "Test"));
		account.add(new Deposit(12.50, "Test Deposit 3", "Test"));
		
		assertEquals("Account income doesn't match expected amount.", 187.50, account.getIncome(null, null));
	}
	
	public void testIncomeWithinDatesOnlyDeposits() {
		Account account = new Account("Test");
		Date start = new Date();
		
		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 10000; i++);

		account.add(new Deposit(100.00, "Test Deposit 1", "Test"));
		account.add(new Deposit(50.00, "Test Deposit 2", "Test"));
		account.add(new Deposit(25.00, "Test Deposit 2", "Test"));
		account.add(new Deposit(12.50, "Test Deposit 3", "Test"));
		
		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 10000; i++);
		
		Date end = new Date();
		assertEquals("Account income doesn't match expected amount.", 187.50, account.getIncome(start, end));
	}

	public void testIncomeOnlyDeposits() {
		Account account = new Account("Test");
		

		account.add(new Deposit(100.00, "Test Deposit 1", "Test"));

		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 10000; i++);
		
		Date start = new Date();
		
		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 10000; i++);

		account.add(new Deposit(100.00, "Test Deposit 2", "Test"));
		account.add(new Deposit(50.00, "Test Deposit 3", "Test"));
		account.add(new Deposit(25.00, "Test Deposit 4", "Test"));
		account.add(new Deposit(12.50, "Test Deposit 5", "Test"));
		
		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 10000; i++);
		
		Date end = new Date();
		
		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 10000; i++);
		
		account.add(new Deposit(12.50, "Test Deposit 6", "Test"));
		
		
		assertEquals("Account income doesn't match expected amount.", 187.50, account.getIncome(start, end));
	}

	public void testIncomeDepositsAndWithdrawals() {
		Account account = new Account("Test");
		

		account.add(new Deposit(100.00, "Test Deposit 1", "Test"));
		account.add(new Withdrawal(-100.0, "Test Withdrawal 1", "Test"));
		
		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 10000; i++);
		
		Date start = new Date();
		
		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 10000; i++);

		account.add(new Deposit(100.00, "Test Deposit 2", "Test"));
		account.add(new Withdrawal(-100.0, "Test Withdrawal 2", "Test"));
		account.add(new Deposit(50.00, "Test Deposit 3", "Test"));
		account.add(new Deposit(25.00, "Test Deposit 4", "Test"));
		account.add(new Deposit(12.50, "Test Deposit 5", "Test"));
		
		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 10000; i++);
		
		Date end = new Date();
		
		// Stall a bit just to make sure its within the dates
		for (int i = 0; i < 10000; i++);
		
		account.add(new Deposit(12.50, "Test Deposit 6", "Test"));
		account.add(new Withdrawal(-12.50, "Test Withdrawal 3", "Test"));
		
		
		assertEquals("Account income doesn't match expected amount.", 187.50, account.getIncome(start, end));
	}
}
