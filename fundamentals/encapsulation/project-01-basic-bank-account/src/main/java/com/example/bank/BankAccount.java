package com.example.bank;

/**
 * A simple bank account with encapsulation.
 * Fields are private, and all modifications go through controlled methods.
 */
public class BankAccount {
    private final String accountNumber;  // immutable, set once
    private String owner;
    private double balance;

    // Constructor with validation
    public BankAccount(String accountNumber, String owner, double initialBalance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }
        if (owner == null || owner.isBlank()) {
            throw new IllegalArgumentException("Owner name cannot be null or empty");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = initialBalance;
    }

    // Getters (no setters for accountNumber – it's final)
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    // We can change owner if needed (with validation)
    public void setOwner(String owner) {
        if (owner == null || owner.isBlank()) {
            throw new IllegalArgumentException("Owner name cannot be null or empty");
        }
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit – positive amount only
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    // Withdraw – positive amount, sufficient funds
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    // Useful to display masked info (senior touch)
    @Override
    public String toString() {
        String masked = "****" + accountNumber.substring(Math.max(0, accountNumber.length() - 4));
        return "BankAccount{" +
                "accountNumber='" + masked + '\'' +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }
}