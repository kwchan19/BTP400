/**
 * 
 */
package org.finance.accounts;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author Ryan Vu (Tien Phat)
 *
 */
public class Chequing extends Account {
	private BigDecimal transactionCharge;
	private ArrayList<BigDecimal> transactions;
	
	public Chequing() { this(null, null, null, "0.25"); }
	
	/**
	 * @param fullName
	 * @param accountNumber
	 * @param balance
	 * @param transactionCharge
	 */
	public Chequing(String fullName, String accountNumber, String balance, String transactionCharge) {
		super(fullName, accountNumber, balance);
		setTransactionCharge(transactionCharge);
		setTransactions(new ArrayList<>());
	}

	/**
	 * @return the transactionCharge
	 */
	public BigDecimal getTransactionCharge() {
		return transactionCharge;
	}

	/**
	 * @param transactionCharge the transactionCharge to set
	 */
	public void setTransactionCharge(BigDecimal transactionCharge) {
		this.transactionCharge = transactionCharge.setScale(2);
	}
	
	/** @param transactionCharge transaction charge */
	public void setTransactionCharge(String transactionCharge) {
		if (transactionCharge == null || transactionCharge.length() == 0) {
			transactionCharge = "0";
		}
		this.transactionCharge = (new BigDecimal(transactionCharge)).setScale(2); 
	}
	
	/**
	 * @return the transactions
	 */
	public ArrayList<BigDecimal> getTransactions() {
		return transactions;
	}

	/**
	 * @param transactions the transactions to set
	 */
	public void setTransactions(ArrayList<BigDecimal> transactions) {
		this.transactions = transactions;
	}

	/** @return account details */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(super.toString());
		BigDecimal totalTransactionCharge = new BigDecimal(0).setScale(2);
		
		for (BigDecimal charge : getTransactions()) {
			if (charge.signum() < 0) {
				totalTransactionCharge.add(charge);
			}
		}
		
		s.append("type: CHEQUING\r\n")
			.append("service charge: $").append(getTransactionCharge())
			.append("\r\nnumber of transactions: ").append(getTransactions().size())
			.append("\r\ntotal amount of service charge: $").append(totalTransactionCharge)
			.append("\r\n");
		
		return s.toString();
	}
	
	/**
	 * Compare to another account. Two account objects are equal if they
	 * have the same account names, account numbers, account balances
	 * and transaction charge. If obj argument is null, return false
	 * 
	 * @param obj account object to be compared to
	 * @return true if equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		Chequing cheq = obj instanceof Chequing ? (Chequing) obj : null;
		
		return cheq != null
			&& super.equals(cheq)
			&& getTransactionCharge().compareTo(cheq.getTransactionCharge()) == 0
			&& getTransactions().equals(cheq.getTransactions());
	}

	/**
	 * Add to current balance by a desired amount
	 * argument. Transaction charge is NOT applied.
	 * Return true if success (both amount argument 
	 * and the result balance are positive). 
	 * 
	 * @param amount amount to be added
	 * @return true if success, otherwise false
	 */
	@Override
	public boolean deposit(BigDecimal amount) {
		boolean valid = super.deposit(amount);
		if (valid) { getTransactions().add(amount); }
		return valid;
	}
	
	/**
	 * Subtract to current balance by a desired amount
	 * argument. Transaction charge is applied.
	 * Return true if success (both amount argument 
	 * and the result balance are positive). 
	 * 
	 * @param amount amount to be subtracted
	 * @return true if success, otherwise false
	 */
	@Override
	public boolean withdraw(BigDecimal amount) {
		boolean valid = amount.signum() >= 0 
				&& super.withdraw(amount.add(getTransactionCharge()));
		if (valid) { getTransactions().add(amount.negate()); }
		return valid;
	}
}
