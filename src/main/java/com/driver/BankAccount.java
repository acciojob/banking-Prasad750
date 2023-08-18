package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;
    private String accountNumber;

    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
        this.accountNumber=null;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String generateAccountNumber(int digits, int sum)throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        helper(digits,sum,"",-1);
        if (this.accountNumber==null)
        {
            throw new Exception("Account Number can not be generated");
        }

        return this.accountNumber;
    }

    public void helper(int digits,int sum,String asf,int k)
    {
        if(sum==0 && digits==0)
        {
            this.accountNumber=asf;
            return;
        }
        if(sum<0 || digits<0)
        {
            return;
        }

        for(int i=0;i<=9;i++)
        {
            if(i>k)
            {
               helper(digits-1,sum-i,asf+i,i);
            }

        }

        return ;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(this.balance<amount)
        {
            throw new Exception("Insufficient Balance");
        }
        this.balance-=amount;

    }

}