/**
 * 
 */
package org.finance.accounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Ryan Vu (Tien Phat)
 *
 */
public class GIC extends Savings {
	private int yearsOfInvestment;
	
	public GIC() { this(null, null, null, "1.25", 1); }
	
	/**
	 * @param fullName
	 * @param accountNumber
	 * @param balance
	 * @param annualInterestRate
	 * @param yearsOfInvestment
	 */
	public GIC(String fullName, String accountNumber, String balance, 
			String annualInterestRate, int yearsOfInvestment) {
		super(fullName, accountNumber, balance, annualInterestRate);
		setYearsOfInvestment(yearsOfInvestment);;
	}

	/**
	 * @return the yearsOfInvestment
	 */
	public int getYearsOfInvestment() {
		return yearsOfInvestment;
	}

	/**
	 * @param yearsOfInvestment the yearsOfInvestment to set
	 */
	public void setYearsOfInvestment(int yearsOfInvestment) {
		this.yearsOfInvestment = yearsOfInvestment >= 0
				? yearsOfInvestment : 0;
	}

	/** @return account details */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(super.toString()
			.replaceFirst("SAVINGS", "GIC"));
		
		s.append("period of investment: ").append(getYearsOfInvestment())
			.append(" year(s)\r\nnew balance at maturity: $").append(getBalanceAtMaturity())
			.append("\r\n");
		
		return s.toString();
	}
	
	/**
	 * Compare to another account. Two account objects are equal if they
	 * have the same account names, account numbers, account balances,
	 * annual interest rate and years of investment. If obj argument
	 * is null, return false
	 * 
	 * @param obj account object to be compared to
	 * @return true if equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		GIC gic = obj instanceof GIC ? (GIC) obj : null;
		
		return gic != null
			&& super.equals(gic)
			&& getYearsOfInvestment() == gic.getYearsOfInvestment();
	}
	
	@Override
	public boolean deposit(BigDecimal amount) { return false; }
	
	@Override
	public boolean withdraw(BigDecimal amount) { return false; }
	
	public BigDecimal getBalanceAtMaturity() {
		return getStartingBalance()
			.multiply(
				(getAnnualInterestRate()
					.divide(new BigDecimal(100))
					.add(new BigDecimal(1))
				).pow(getYearsOfInvestment())
			)
			.setScale(2, RoundingMode.HALF_UP);
	}
}
