package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.BankAccount;

public class ExtendedStrictBankAccount extends SimpleBankAccount{

    private static final double TRANSACTION_FEE = 0.1;

    private int transactions;
    private double balance;

    public ExtendedStrictBankAccount(final int id, final double balance){
        super(id,balance);
    }
    
    public void deposit(final int id, final double amount){
        super.deposit(id, amount);
    }

    public void withdraw(final int id, final double amount){
        if (isWithdrawAllowed(amount)) {
            super.withdraw(id, amount);
        }
    }

    public void depositFromATM(final int id, final double amount){
        super.depositFromATM(id, amount);
    }

    public void withdrawFromATM(final int id, final double amount){
        super.withdrawFromATM(id, amount);
    }

    public void chargeManagementFees(final int id) {
        final double feeAmount = MANAGEMENT_FEE + transactions * ExtendedStrictBankAccount.ATM_TRANSACTION_FEE;
        if (checkUser(id) && isWithdrawAllowed(feeAmount)) {
            balance -= feeAmount;
            transactions = 0;
        }
    }

    private boolean isWithdrawAllowed(final double amount) {
        return balance >= amount;
    }
}