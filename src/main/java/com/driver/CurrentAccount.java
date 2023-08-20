package com.driver;

import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId=tradeLicenseId;
        if(balance<5000)
        {
            throw new Exception("Insufficient Balance");
        }

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

            if(!isValidId(this.tradeLicenseId))
            {
               if(!canRearrange(tradeLicenseId))
               {
                   throw new Exception("Valid License can not be generated");
               }
            }

    }
    public boolean isValidId(String str)
    {
        for(int i=1;i<str.length();i++)
        {
            int j=i-1;
            char a=this.tradeLicenseId.charAt(i);
            char b=this.tradeLicenseId.charAt(j);

            if(a==b)
            {
                return false;
            }
        }
        return true;
    }

    public boolean canRearrange(String str)
    {
        int []arr =new int[26];
        for(int i=0;i<str.length();i++)
        {
            arr[str.charAt(i)-'A']++;
        }

        int maxIdx=getMaxIdx(arr);
        //System.out.println((char) (arr[maxIdx]+'A'));

        if(arr[maxIdx]>((str.length()+1)/2))
        {
            return false;
        }

        this.tradeLicenseId=helperRearrange(str,arr,maxIdx);
     //   System.out.println(id);

        return true;
    }

    public int getMaxIdx(int []arr)
    {
        int max=-1;
        int maxIdx;
        for(int i=0;i<arr.length;i++)
        {
            if(max<arr[i])
            {
                maxIdx=i;
                max=arr[i];
            }
        }
        return max;
    }

    public String helperRearrange(String str,int []arr,int maxInd)
    {
        String id="";
        for (int i=0;i<str.length();i++)
        {
            id+=' ';
        }

        char ch=(char) (maxInd+'A');
        int maxCnt=arr[maxInd];
        int idx=0;
        while(maxCnt>0)
        {
            id=id.substring(0,idx)+ch+id.substring(idx+1);
            maxCnt--;
            idx+=2;
        }

        arr[maxInd]=0;
        for(int i=0;i<arr.length;i++)
        {
            while(arr[i]>0)
            {
                ch=(char)(i+'A');
                idx=(idx>str.length()) ? 1:idx;
                id=id.substring(0,idx)+ch+id.substring(idx+1);
                arr[i]--;
                idx+=2;
            }
        }
        return id;

    }

}
