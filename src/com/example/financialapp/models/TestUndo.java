package com.example.financialapp.models;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestUndo extends TestCase {
    
    TransactionModel transactions;
    
    public void setUp() {
        transactions = new SimpleTransactionModel();
    }
    
    public void testEmpty() {
        assertNull(transactions.undoTransaction());
    }
    
    public void testDoubleEmpty() {
        assertNull(transactions.undoTransaction());
        assertNull(transactions.undoTransaction());
    }
    
    public void testSingle() {
        Transaction t = new Deposit(50, "Test Transaction", "Test Taking Fee");
        transactions.add(t);
        assertEquals(t, transactions.undoTransaction());
    }
    
    public void testMany() {
        Transaction t1 = new Deposit(1, "1", "1");
        Transaction t2 = new Withdrawal(2, "2", "2");
        Transaction t3 = new Deposit(3, "3", "3");
        Transaction t4 = new Withdrawal(4, "4", "4");
        Transaction t5 = new Deposit(5, "5", "5");
        Transaction t6 = new Withdrawal(6, "6", "6");
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.add(t6);
        for(Transaction t : list) {
            transactions.add(t);
        }
        for(int i = list.size() - 1; i >= 0; i--) {
            assertEquals(transactions.undoTransaction(), list.get(i));
        }
    }
    
    public void testManyEmpty() {
        Transaction t1 = new Deposit(1, "1", "1");
        Transaction t2 = new Withdrawal(2, "2", "2");
        Transaction t3 = new Deposit(3, "3", "3");
        Transaction t4 = new Withdrawal(4, "4", "4");
        Transaction t5 = new Deposit(5, "5", "5");
        Transaction t6 = new Withdrawal(6, "6", "6");
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.add(t6);
        for(Transaction t : list) {
            transactions.add(t);
        }
        for(int i = list.size() - 1; i >= 0; i--) {
            assertEquals(transactions.undoTransaction(), list.get(i));
        }
        assertNull(transactions.undoTransaction());
    }
}
