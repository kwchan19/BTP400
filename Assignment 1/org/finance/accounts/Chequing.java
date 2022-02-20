package org.finance.accounts;

import java.math.BigDecimal;
import java.util.*;

public class Chequing extends Account {
    private BigDecimal serviceCharge;
    private BigDecimal totalCharge;
    private ArrayList<BigDecimal> transactions = new ArrayList<BigDecimal>();

    public Chequing(){
        super();
        serviceCharge = new BigDecimal(0.25);
        totalCharge = serviceCharge;
    }

    public Chequing(String name, String accnum, String bal, String charge){
        super(name,accnum,bal);
        serviceCharge = new BigDecimal(charge.trim());
        totalCharge = serviceCharge;
        transactions = new ArrayList<>();
        
    }

    
    public boolean deposit(BigDecimal amount){
    	if(amount.doubleValue() > 0){
    		currentBal = currentBal.add(amount);
    		transactions.add(amount); 
			return true;
		}
		return false;
    	
    }
    
    

    public boolean withdraw(BigDecimal amount){
        BigDecimal temp = currentBal.subtract(amount);
        if(amount.doubleValue() > 0 || temp.doubleValue() > 0){
        	currentBal = currentBal.subtract(amount); 
            currentBal = currentBal.subtract(serviceCharge);
            totalCharge = totalCharge.add(serviceCharge);
            transactions.add(amount.multiply(BigDecimal.valueOf(-1))); 
            return true;
        }
        else {
        	
            return false;
        }
    }
    
    

    public boolean equals(Object z) {
        boolean result = false;
        if (z instanceof Chequing) {
            Chequing z2 = (Chequing) z;
            if(super.getFullName() != null && super.getAccountNumber() != null)
				if(super.getFullName().equalsIgnoreCase(z2.getFullName())
						&& super.getAccountNumber().equalsIgnoreCase(z2.getAccountNumber())
						&& super.getAccountBalance() == z2.getAccountBalance()
						&& serviceCharge == z2.serviceCharge
						&& transactions == z2.transactions)
						
					result = true;
			else 
				return result;
        }
      return result;
    }
    
    public String toString(){
        String s;
        s = super.toString() + "\ntype: CHEQUING\n" +
        "service charge: $" + serviceCharge + "\n" +
        "number of transactions: " + transactions.size() + "\n" +
        "total amount of service charge: $" + totalCharge;
        return s;
    }

	public BigDecimal sc() {
		
		
		return serviceCharge;
	}
  

}