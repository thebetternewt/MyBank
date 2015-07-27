package com.starkvilletech.chris.accounts;

import java.util.ArrayList;

/**
 * Created by cre48 on 7/22/15.
 */
public abstract class BankAccount {
    private ArrayList<Double> mTransactions;
    public static final double OVERDRAFT_FEE = 30;

    BankAccount(){
        mTransactions = new ArrayList<Double>();
    }

    public void withdraw(double amount){
        mTransactions.add(-amount);
        if (getBalance() < 0) {
            mTransactions.add(-OVERDRAFT_FEE);
        }
    }

    protected int numberOfWithdrawals(){
        int count = 0;
        for (int i = 0; i < mTransactions.size(); i++) {
            if(mTransactions.get(i) < 0) {
                count++;
            }
        }
        return count;
    }

    public void deposit(double amount){
        mTransactions.add(amount);
    }

    public double getBalance(){
        double total = 0;
        for(int i = 0; i < mTransactions.size(); i++){
            total += mTransactions.get(i);
        }
        return total;
    }

}
