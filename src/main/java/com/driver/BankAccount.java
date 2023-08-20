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

        if(digits*9<sum)
        {
            throw new Exception("Account Number can not be generated");
        }
        helper(digits,sum,"");

        return this.accountNumber;
    }

    public boolean helper(int digits,int sum,String asf)
    {
        if(sum==0 && digits==0)
        {
            this.accountNumber=asf;
            return true;
        }
        if(sum<=0 || digits<=0)
        {
            return false;
        }

        for(int i=0;i<=9;i++)
        {
               if(helper(digits-1,sum-i,asf+i))
               {
                   return true;
               }
        }

        return false ;
//        //        remaining number
//        int rem = sum;
//        String accNo = "";
//        if(digits*9 < sum){
//            throw new Exception("Account Number can not be generated");
//        }
//        else{
//            while(digits > 0 && rem > 0){
//                if(rem >= 9){
//                    rem = rem - 9;
//                    accNo = accNo + "9";
//                }
//                else{
//                    accNo = accNo + Integer.toString(rem);
//                    rem = 0;
//                }
//                digits--;
//            }
//            while(digits > 0){
//                accNo = accNo + "0";
//                digits--;
//            }
//            return accNo;
//        }
////        return null
//

    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(this.balance-amount >= minBalance)
        {
            this.balance-=amount;
        }
        else
        {
            throw new Exception("Insufficient Balance");

        }

    }

}