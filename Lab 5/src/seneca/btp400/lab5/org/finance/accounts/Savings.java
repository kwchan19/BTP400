/**
 * 
 */
package org.finance.accounts;

import java.math.BigDecimal;

/**
 * @author Ryan Vu (Tien Phat)
 *
 */
public class Savings extends Account {
	private BigDecimal annualInterestRate;
	
	public Savings() { this(null, null, null, "0.3"); }
	
	/**
	 * @param fullName
	 * @param accountNumber
	 * @param balance
	 * @param annualInterestRate
	 */
	public Savings(String fullName, String accountNumber, String balance, String annualInterestRate) {
		super(fullName, accountNumber, balance);
		setAnnualInterestRate(annualInterestRate);
	}


	/**
	 * @return the annualInterestRate
	 */
	public BigDecimal getAnnualInterestRate() {
		return annualInterestRate;
	}


	/**
	 * @param annualInterestRate the annualInterestRate to set
	 */
	public void setAnnualInterestRate(BigDecimal annualInterestRate) {
		this.annualInterestRate = annualInterestRate.setScale(2);
	}
	
	/** @param annualInterestRate the annualInterestRate to set */
	public void setAnnualInterestRate(String annualInterestRate) {
		if (annualInterestRate == null || annualInterestRate.length() == 0) {
			annualInterestRate = "0";
		}
		this.annualInterestRate = (new BigDecimal(annualInterestRate)).setScale(2); 
	}
	
	/** @return account details */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(super.toString());
		
		s.append("type: SAVINGS\r\n")
			.append("annual interest rate: ").append(getAnnualInterestRate())
			.append("%\r\n");
		
		return s.toString();
	}
	
	/**
	 * Compare to another account. Two account objects are equal if they
	 * have the same account names, account numbers, account balances
	 * and annual interest rate. If obj argument is null, return false
	 * 
	 * @param obj account object to be compared to
	 * @return true if equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		Savings sav = obj instanceof Savings ? (Savings) obj : null;
		
		return sav != null
			&& super.equals(sav)
			&& getAnnualInterestRate().compareTo(sav.getAnnualInterestRate()) == 0;
	}
}
