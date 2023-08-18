package com.driver;

import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        if(balance<5000)
        {
            throw new Exception("Insufficient Balance");
        }

        this.tradeLicenseId=tradeLicenseId;


    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        int i=1,j=0;
        while (i<this.tradeLicenseId.length())
        {
            char a=this.tradeLicenseId.charAt(i);
            char b=this.tradeLicenseId.charAt(j);

            if(a==b)
            {
               if(!canRearrange(tradeLicenseId))
               {
                   throw new Exception("Valid License can not be generated");
               }
            }
        }
    }

    public boolean canRearrange(String str)
    {
        int []arr =new int[123];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<str.length();i++)
        {
            arr[str.charAt(i)-0]++;
        }

        for(int i:arr)
        {
            max= Math.max(max,i);
        }

        if(max>((str.length()+1)/2))
        {
            return true;
        }

        return false;
    }

}
