/*
 * 
 */
package org.finance.accounts;

import java.math.BigDecimal;

/**
 * Simple account class including following details:
 * <ul>
 * <li> Account's full name
 * <li> Account number
 * <li> Account balance
 * </ul>
 * 
 * @author Ryan Vu (Tien Phat) - https://github.com/pynnl
 * @version %G%
 */
public class Account {
	/** Account's full name */
	private String fullName;
	
	/** Account number */
	private String accountNumber;
	
	/** Account balance */
	private BigDecimal balance;
	private BigDecimal startingBalance;
	
	/** 
	 * Construct account with empty account name,
	 * account number and zero balance
	 */
	public Account() { this(null, null, null); }
	
	/**
	 * @param fullName account's full name
	 * @param accountNumber account number
	 * @param balance account balance
	 */
	public Account(String fullName, String accountNumber, String balance) {
		setFullName(fullName);
		setAccountNumber(accountNumber);
		
		setBalance(balance);
		setStartingBalance(getBalance());
	}
	
	/** @return account's full name */
	public String getFullName() { return fullName; }
	
	/**
	 * Set account number. If fullName argument
	 * is null, set it to empty string
	 * 
	 * @param fullName account number
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName != null ? fullName : "";
	}
	
	/** @return account number */
	public String getAccountNumber() { return accountNumber; }
	
	/**
	 * If accountNumber argument is null, set it to empty string
	 * 
	 * @param accountNumber account number
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber != null ? accountNumber : "";
	}
	
	/** @return account balance */
	public BigDecimal getBalance() { return balance; }
	
	/** @param balance account balance */
	public void setBalance(BigDecimal balance) { 
		this.balance = balance.setScale(2); 
	}
	
	/** @param balance account balance */
	public void setBalance(String balance) {
		if (balance == null || balance.length() == 0) {
			balance = "0";
		}
		this.balance = (new BigDecimal(balance)).setScale(2); 
	}
	
	/**
	 * @return the startingBalance
	 */
	public BigDecimal getStartingBalance() {
		return startingBalance;
	}

	/**
	 * @param startingBalance the startingBalance to set
	 */
	public void setStartingBalance(BigDecimal startingBalance) {
		this.startingBalance = startingBalance.setScale(2);
	}

	/** @return account details */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		s.append("number: ").append(getAccountNumber())
			.append(", name: ").append(getFullName())
			.append("\r\nstarting balance: ").append(getStartingBalance())
			.append(", current balance: ").append(getBalance())
			.append("\r\n");
		
		return s.toString();
	}
	
	/**
	 * Compare to another account. Two account objects are equal if they
	 * have the same account names, account numbers and account balances.
	 * If obj argument is null, return false
	 * 
	 * @param obj account object to be compared to
	 * @return true if equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		Account acc = obj instanceof Account ? (Account) obj : null;
		
		return acc != null
			&& acc.getFullName().equals(getFullName())
			&& acc.getAccountNumber().equals(getAccountNumber())
			&& acc.getBalance().compareTo(getBalance()) == 0;
	}
	
	/**
	 * Add to current balance by a desired amount
	 * argument. Return true if success (amount
	 * argument are positive)
	 * 
	 * @param amount amount to be added
	 * @return true if success, otherwise false
	 */
	public boolean deposit(BigDecimal amount) {
		boolean valid = amount.signum() >= 0;
		if (valid) { setBalance(getBalance().add(amount)); }
		return valid;
	}
	
	/**
	 * Subtract to current balance by a desired amount
	 * argument. Return true if success (amount
	 * argument and the updated balance are positive)
	 * 
	 * @param amount amount to be subtracted
	 * @return true if success, otherwise false
	 */
	public boolean withdraw(BigDecimal amount) {
		BigDecimal result = null;
		boolean valid = amount.signum() >= 0
				&& (result = getBalance().subtract(amount)).signum() >= 0;
		if (valid) { setBalance(result); }
		return valid;
	}
}