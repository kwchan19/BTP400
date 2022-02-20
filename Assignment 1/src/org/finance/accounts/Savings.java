package org.finance.accounts;
import java.math.BigDecimal;

public class Savings extends Account {
    private BigDecimal annualInterest;

    public Savings(){
        super();
        annualInterest = new BigDecimal(0.3);
    }

    public Savings(String name, String accnum, String startingBal, String interest){
        super(name, accnum, startingBal.trim());
        annualInterest = new BigDecimal(interest.trim());
    }

    public boolean equals(Object z) {
        boolean result = false;
        if (z instanceof Savings) {
        	Savings z2 = (Savings) z;
            if ( (z2.fullName.equals(fullName)) && (z2.accNumber.equals(accNumber)) && (z2.currentBal.equals(currentBal)) && (z2.annualInterest == (annualInterest))){
                result = true;
            }
        }
        return result;
    }

    public String toString() {
        String s;
        s = super.toString() + "\ntype: SAVINGS\n" +
        "annual interest rate: " + annualInterest + "%";
        return s;
    }
    
    public BigDecimal Interest() {
    	return annualInterest;
    }

}