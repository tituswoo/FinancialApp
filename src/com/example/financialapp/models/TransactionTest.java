package com.example.financialapp.models;

import junit.framework.TestCase;

/**
 * Test cases for the Transaction class.
 * @author Toma Tadros
 *
 */

public class TransactionTest extends TestCase {

	public void setUp() {
		Transaction t = new Transaction(100, "Description", "Category");
	}
	
	public void testCategory() {
		Transaction t = new Transaction(100, "Desc", "Food");
		assertEquals(t.getCategory(), "Food");
		
		t.setCategory("Rent");
		assertEquals(t.getCategory(), "Rent");
	}
	
	public void testDescription() {
		Transaction t = new Transaction(100, "Taco Bell", "Food");
		assertEquals(t.getDescription(), "Taco Bell");
		
		t.setDescription("Subway");
		assertEquals(t.getDescription(), "Subway");
	}
	
	public void testAmount() {
		Transaction t = new Transaction(100, "Desc", "Cat");
		assertEquals(t.getAmount(), 100.0);
		
		t.setAmount(99.99);
		assertEquals(t.getAmount(), 99.99);
	}

}
