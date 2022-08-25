package com.willcampbell;

public class BankAccount {
    private final String firstName;
    private final String lastName;
    private double balance;
    private final typeOfAccount accountType;
    private final double maxWithdrawalATM = 500.0;
    enum typeOfAccount {
        CHECKING,
        SAVINGS
    }

    public BankAccount(String firstName, String lastName, double balance, typeOfAccount accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = accountType;
    }

    // The branch argument is true deposit is made at a branch, with a teller.
    // false if deposit is made at an ATM
    public double deposit(double amount, boolean branch) {
        balance += amount;
        return balance;
    }

    // The branch argument is true withdrawal is made at a branch, with a teller.
    // false if withdrawal is made at an ATM
    public double withdraw(double amount, boolean branch) {
        if (!branch && amount > maxWithdrawalATM) {
            throw new IllegalArgumentException();
        }
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking(){
        return accountType == typeOfAccount.CHECKING;
    }

    // more methods that use first and last name - etc.
}
