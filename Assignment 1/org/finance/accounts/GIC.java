package org.finance.accounts;

import java.math.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class GIC extends Account {
    private int poi;
    private BigDecimal annualInterest;

    public GIC(){
        super();
        poi = 1;
        annualInterest = new BigDecimal(1.25);
    }

    public GIC(String name, String accnum, String bal, int period, String interest){
        super(name,accnum,bal);
        poi = period;
        annualInterest = new BigDecimal(interest);
    }

    public boolean deposit(BigDecimal amount){
        return false;
    }

    public boolean withdraw(BigDecimal amount){
        return false;
    }
    
    public BigDecimal getBalanceAtMaturity() { 
		
    	BigDecimal temp = super.currentBal.multiply(new BigDecimal(Math.pow((1 + (annualInterest.doubleValue() / (100))), poi)));
		
		return temp; 
	}
    
    public boolean equals(Object z){
        boolean result = false;
        if ( z instanceof GIC ){
        	GIC z2 = (GIC) z;
            if ((z2.fullName.equals(fullName)) && (z2.accNumber.equals(accNumber)) && (z2.currentBal.equals(currentBal)) && (z2.poi==poi) && (z2.annualInterest==annualInterest)){
                result = true;
            }
        }
        return result;
    }

    public String toString(){
        String s;
        NumberFormat dec = new DecimalFormat("#0.00");     
        s = super.toString() + "\ntype: GIC\n" +
        "annual interest rate: " + annualInterest + "%\n"
        + "period of investment: " + poi + " years\n" + 
        "new balance at maturity: $" + dec.format(getBalanceAtMaturity());
        return s;
    }
    
    public BigDecimal ai() {
    	return annualInterest;
    }
    
    public int pois() {
    	return poi;
    }

}