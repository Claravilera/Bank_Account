package dev.clara.bank_account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

    @Test
    public void testSavingsAccountDeposit() {
        SavingsAccount savings = new SavingsAccount(12000, 0.05f);
        savings.deposit(3000);
        assertEquals(15000, savings.balance);
        assertTrue(savings.printDetails().contains("Account Active: true"));
    }

    @Test
    public void testSavingsAccountWithdraw() {
        SavingsAccount savings = new SavingsAccount(15000, 0.05f);
        savings.withdraw(5000);
        assertEquals(10000, savings.balance);
        assertTrue(savings.printDetails().contains("Account Active: true"));
    }

    @Test
    public void testSavingsAccountMonthlyStatement() {
        SavingsAccount savings = new SavingsAccount(15000, 0.05f);
        savings.withdraw(3000);
        savings.withdraw(3000);
        savings.withdraw(3000);
        savings.withdraw(3000);
        savings.withdraw(3000);
        savings.monthlyStatement();
        assertEquals(9037.5, savings.balance, 0.01);

    }
}
