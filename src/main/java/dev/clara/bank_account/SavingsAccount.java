package dev.clara.bank_account;

class SavingsAccount extends Account {
    private boolean isActive;

    public SavingsAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
        this.isActive = balance >= 10000;
    }

    @Override
    public void deposit(float amount) {
        if (isActive) {
            super.deposit(amount);
            updateAccountStatus();
        }
    }

    @Override
    public void withdraw(float amount) {
        if (isActive) {
            super.withdraw(amount);
            updateAccountStatus();
        }
    }

    @Override
    public void monthlyStatement() {
        if (numberOfWithdrawals > 4) {
            monthlyFee += (numberOfWithdrawals - 4) * 1000;
        }
        super.monthlyStatement();
        updateAccountStatus();
    }

    private void updateAccountStatus() {
        isActive = balance >= 10000;
    }

    @Override
    public String printDetails() {
        return super.printDetails() + ", Account Active: " + isActive;
    }
}
