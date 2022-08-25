package com.willcampbell;

import org.junit.*;

import static org.junit.Assert.*;

public class BankAccountTest {
    private static int count = 0;
    private BankAccount bankAccount;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before all tests. Count = " + count++);
    }

    @Before
    public void setup() {
        System.out.println("Running setup. Count = " + count++);
        bankAccount = new BankAccount("Will", "Campbell", 1000.0, BankAccount.typeOfAccount.CHECKING);
    }

    @Test
    public void deposit(){
        System.out.println("Running deposit. Count = " + count++);
        double balance = bankAccount.deposit(200.0, true);
        assertEquals(1200.0, balance, 0);
    }

    @Test
    public void withdrawAtBranch() {
        System.out.println("Running withdraw. Count = " + count++);
        double balance = bankAccount.withdraw(600.0, true);
        assertEquals(400.0, balance, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdrawAtATMFails() {
        System.out.println("Running withdraw. Count = " + count++);
        bankAccount.withdraw(600.0, false);
        fail("Should have thrown and IllegalArgumentException");
    }

    @Test
    public void withdrawAtATMSucceeds() {
        System.out.println("Running withdraw. Count = " + count++);
        double balance = bankAccount.withdraw(500.0, false);
        assertEquals(500.0, balance, 0);
    }

    @Test
    public void getBalanceDeposit() {
        System.out.println("Running getBalanceDeposit. Count = " + count++);
        double balance = bankAccount.deposit(200.0, true);
        assertEquals(1200.0, bankAccount.getBalance(), 0);
    }

    @Test
    public void getBalanceWithdraw() {
        System.out.println("Running getBalanceWithdraw. Count = " + count++);
        double balance = bankAccount.withdraw(200.0, true);
        assertEquals(800.0, bankAccount.getBalance(), 0);
    }

    @Test
    public void isChecking() {
        System.out.println("Running isChecking. Count = " + count++);
        assertTrue("The account is NOT a checking account", bankAccount.isChecking());
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After all tests. Count = " + count++);
    }

    @After
    public void tearDown() {
        System.out.println("Running teardown. Count = " + count++);
    }
}
