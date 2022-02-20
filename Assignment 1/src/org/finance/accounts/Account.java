package org.finance.accounts;

import java.math.BigDecimal;

public class Account {
    protected String fullName;
    protected String accNumber;
    protected BigDecimal currentBal;
    protected BigDecimal startingBalance;
    
    public Account(){
        this.fullName = "";
        this.accNumber = "";
        this.currentBal = new BigDecimal(0);
        this.currentBal = currentBal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public Account(String name, String num, String bal){
        if(name != null) {
            setFullName(name);
        } 
        else {
            setFullName("");
        } 

        if(num != null){
            setAccountNumber(num);
        }
        else {
            setAccountNumber("");
        }

        if(bal.equals("-1")){
            setAccountBalance("0");
        }
        else {
        	bal = bal.trim();
            currentBal = (new BigDecimal(bal));
            currentBal = currentBal.setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        

        startingBalance = currentBal;
   
    }

    //toString method
    public String toString(){
        String s;
        s = "number: " + accNumber + ", name: " + fullName + "\n" + "starting balance: $" + startingBalance + ", current balance: $" + currentBal;
        return s;
    }

    //setter for name
    public void setFullName(String name){
        fullName = name;
    }
    
    //setter for account number
    public void setAccountNumber(String num){
        accNumber = num;
    }

    //setter for account balance
    public void setAccountBalance(String bal){
        currentBal = new BigDecimal(bal);
        currentBal = currentBal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    //getter for full name
    public String getFullName(){
        return fullName;
    }
    
    //getter for account number
    public String getAccountNumber(){
        return accNumber;
    }

    //getter for account balance
    public BigDecimal getAccountBalance(){
        return currentBal;
    }

    public boolean equals(Object z){
        boolean result = false;
        if (z instanceof Account){
            Account z2 = (Account) z;
            if ((z2.fullName.equals(fullName)) && (z2.accNumber.equals(accNumber)) && (z2.currentBal == currentBal)){
			     result = true;
            }

        }
        return result;
    }

    public boolean deposit(BigDecimal amount){
    	if(amount.doubleValue() > 0){
    		currentBal = currentBal.add(amount);
			return true;
		}
		return false;
    	
    }

    public boolean withdraw(BigDecimal amount){
        BigDecimal temp = currentBal.subtract(amount);
        if(amount.doubleValue() < 0 || temp.doubleValue()< 0){
            return false;
        }
        else {
            currentBal = currentBal.subtract(amount);
            return true;
        }
    }
}