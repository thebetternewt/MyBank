package com.starkvilletech.chris.accounts;

import com.starkvilletech.chris.accounts.BankAccount;

/**
 * Created by ChrisMac on 7/27/15.
 */
public class SavingsAccount extends BankAccount {
    private static final String TAG = "SavingsAccount";
    @Override
    public void withdraw(double amount) {
        if(numberOfWithdrawals() >= 3){
            return;
        }
        super.withdraw(amount);
    }
}
