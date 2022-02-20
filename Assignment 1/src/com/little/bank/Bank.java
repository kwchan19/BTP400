package com.little.bank;

import java.math.BigDecimal;
import java.util.*;

import org.finance.accounts.Account;

public class Bank {
    private String nameofBank;
    private ArrayList<Account> accArray; 
    
    public String bankName() {
    	return nameofBank;
    }

    public Bank(){
        nameofBank = "Seneca@York";
        accArray = new ArrayList<Account>();
    }

    public Bank(String s){
        nameofBank = s;
        accArray = new ArrayList<Account>();
    }

    public boolean addAccount(Account newAccount){
        if(newAccount != null){
            String num = newAccount.getAccountNumber();
            for(int i = 0; i < accArray.size(); i++){
                if(accArray.get(i).getAccountNumber().contains(num)) {
                    return false;
                }
            }
            accArray.add(newAccount);
            if(accArray.contains(newAccount)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public Account[] searchByBalance(String bal) {
    	Account[] temp = new Account[0];
		if(Double.parseDouble(bal) < 0) {
			return temp;
		}
		int index = 0;
		int[] found = new int[accArray.size()];
		
		for(int i = 0; i < accArray.size(); i++) {
			if(accArray.get(i).getAccountBalance().equals(new BigDecimal(bal))) {
				found[index] = i;
				index++;
			}
		}
		
		if(index > 0) {
			temp = new Account[index];
			for(int k = 0; k < index; k++) {
				temp[k] = accArray.get(found[k]);
			}
		}
		return temp;

    }

    public String toString(){
        String s;
        s =  "*** Welcome to the Bank of Kevin Chan ***\n" +
             "It has " + accArray.size() + " accounts.\n";
        for(int i = 0; i < accArray.size(); i++){
            s += ( (i+1) + " " + accArray.get(i) + '\n');
        }
        return s;
    }

    public boolean equals(Object z){
        boolean flag = false;
        if(z instanceof Bank) {
            Bank z2 = (Bank)z;
			if(nameofBank != null && accArray != null){
				if(nameofBank.equals(z2.nameofBank) && accArray.containsAll(z2.accArray)){
                    flag = true;
                }
            }
        }
        return flag;

    }

    public Account[] searchByAccountName(String accountName){
        int flag=0;
		for(int i=0;i<accArray.size();i++) {
			if(accArray.get(i).getFullName().equals(accountName)) {
				flag++;
			}
		}
		Account[] arr = new Account[flag];
		if(flag==0) {
			return arr;
		}
		
		int index=0;
		
		for(int i=0;i<accArray.size();i++) {
			if(accArray.get(i).getFullName().equals(accountName)) {
				arr[index]=accArray.get(i);
				index++;
			}
		}
		return arr;
    }
    
    public Account searchByAccountNumber(String accountNumber) {
		if(!accountNumber.equals(null) && !accountNumber.equals("")) {
			for(int i=0;i<accArray.size();i++) {
				if(accArray.get(i).getAccountNumber().equals(accountNumber)) {
					return accArray.get(i);
				}
			}
        }
        return null;
        
    }

    public Account removeAccount(String accountNumber){
        if(!accountNumber.equals(null) && !accountNumber.equals("")){
			for(int i=0;i<accArray.size();i++){
				if(accArray.get(i).getAccountNumber().equals(accountNumber)){
					Account acc;
					acc = accArray.get(i);
					accArray.remove(i);
					return acc; 
				}
			}
        }
        return null;
        
    }
    
    public Account[] getAllAccounts() {
		
		Account[] temp = new Account[0];
		
		if(accArray.size() > 0) {
			
			temp = new Account[accArray.size()];
			for(int i = 0; i < accArray.size(); i++) {
				temp[i] = accArray.get(i);
			}
		}
		
		return temp;
	}
    

}