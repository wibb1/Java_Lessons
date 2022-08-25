package com.willcampbell;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountTestParameterized {
    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @Before
    public void setup() {
        account = new BankAccount("Will", "Campbell", 1000.0, BankAccount.typeOfAccount.CHECKING);
        System.out.println("Completed setup.");
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions() {
        return Arrays.asList(new Object[][]{
                {100.0, true, 1100.0},
                {200.0, true, 1200.0},
                {399.99, true, 1399.99},
                {455.55, true, 1455.55},
                {52000.0, true, 53000.0},
        });
    }

    @Test
    public void deposit(){
        System.out.println("Running deposit. Balance + Amount = Expected " + account.getBalance() + " + " + amount + " = " + expected);
        double balance = account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), 0);
    }
}
