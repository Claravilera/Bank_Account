package dev.clara.bank_account;

public class Account {
    protected float balance;
    protected int numberOfDeposits = 0;
    protected int numberOfWithdrawals = 0;
    protected float annualInterestRate;
    protected float monthlyFee = 0;

    public Account(float balance, float annualInterestRate) {
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
            numberOfDeposits++;
        }
    }

    public void withdraw(float amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            numberOfWithdrawals++;
        }
    }

    public void calculateMonthlyInterest() {
        float monthlyInterest = (annualInterestRate / 12) * balance;
        balance += monthlyInterest;
    }

    public void monthlyStatement() {
        balance -= monthlyFee;
        calculateMonthlyInterest();
    }

    public String printDetails() {
        return "Balance: " + balance + ", Monthly Fee: " + monthlyFee + ", Deposits: " + numberOfDeposits + ", Withdrawals: " + numberOfWithdrawals;
    }
}
