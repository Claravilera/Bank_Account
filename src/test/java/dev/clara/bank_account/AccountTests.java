package dev.clara.bank_account;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTests {

    @Test
    public void testAccountDeposit() {
        Account account = new Account(5000, 0.05f);
        account.deposit(2000);
        assertEquals(7000, account.balance);
        assertEquals(1, account.numberOfDeposits);
    }

    @Test
    public void testAccountWithdraw() {
        Account account = new Account(5000, 0.05f);
        account.withdraw(2000);
        assertEquals(3000, account.balance);
        assertEquals(1, account.numberOfWithdrawals);
    }

    @Test
    public void testAccountCalculateMonthlyInterest() {
        Account account = new Account(12000, 0.06f);
        account.calculateMonthlyInterest();
        assertEquals(12060, account.balance, 0.01);
    }

    @Test
    public void testAccountMonthlyStatement() {
        Account account = new Account(10000, 0.06f);
        account.monthlyFee = 500;
        account.monthlyStatement();
        assertEquals(9547.5, account.balance, 0.01);
    }

}
