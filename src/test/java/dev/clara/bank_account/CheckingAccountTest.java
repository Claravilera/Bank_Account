package dev.clara.bank_account;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CheckingAccountTest {


    @Test
    public void testCheckingAccountWithdrawWithoutOverdraft() {
        CheckingAccount checking = new CheckingAccount(10000, 0.05f);
        checking.withdraw(5000);
        assertEquals(5000, checking.balance);
        assertEquals(0, checking.overdraft);
    }

    @Test
    public void testCheckingAccountWithdrawWithOverdraft() {
        CheckingAccount checking = new CheckingAccount(10000, 0.05f);
        checking.withdraw(15000);
        assertEquals(0, checking.balance);
        assertEquals(5000, checking.overdraft);
    }

    @Test
    public void testCheckingAccountDepositReducesOverdraft() {
        CheckingAccount checking = new CheckingAccount(10000, 0.05f);
        checking.withdraw(15000);
        checking.deposit(7000);
        assertEquals(2000, checking.balance);
        assertEquals(0, checking.overdraft);
    }

    @Test
    public void testCheckingAccountMonthlyStatement() {
        CheckingAccount checking = new CheckingAccount(10000, 0.05f);
        checking.withdraw(5000);
        checking.monthlyFee = 300;
        checking.monthlyStatement();
        assertEquals(4700, checking.balance);
    }
}
