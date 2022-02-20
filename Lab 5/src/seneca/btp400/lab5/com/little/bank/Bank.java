/**
 * 
 */
package com.little.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.finance.accounts.Account;

/**
 * Simple bank class including following details:
 * <ul>
 * <li> Bank's name
 * <li> ArrayList of Account
 * </ul>
 * 
 * @author Ryan Vu (Tien Phat) - https://github.com/pynnl
 * @version %G%
 */
public class Bank {
	/** Name of the bank */
	private String name;

	/** List of accounts */
	private ArrayList<Account> accounts;

	/** Construct Bank with name "Seneca&York" */
	public Bank() { this("Seneca@York"); }

	/** @param name name of the bank */
	public Bank(String name) {
		setName(name);
		setAccounts(new ArrayList<>());
	}

	/**
	* @return the name
	*/
	public String getName() { return name; }

	/**
	 * @param name the name to set
	 */
	public void setName(String name) { this.name = name; }

	/**
	 * @return the accounts
	 */
	public ArrayList<Account> getAccounts() { return accounts; }

	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(ArrayList<Account> accounts) { this.accounts = accounts; }

	/**
	 * Add an account to the bank. Return true if success, false if
	 * account argument is null or has duplicated account number
	 * 
	 * @param account new account to be added
	 * @return if the addition is success
	 */
	public boolean addAccount(Account account) {
		if (account != null) {
			if (searchByAccountNumber(account.getAccountNumber()) == null) {
				getAccounts().add(account);
				return true;
			}
		}

		return false;
	}

	
	/**
	 * Remove an account to the bank. Return the removed
	 * account or null if failed
	 * 
	 * @param accountNumber removed account's number
	 * @return the account to be removed
	 */
	public Account removeAccount(String accountNumber) {
		Account result = searchByAccountNumber(accountNumber);
		if (result != null) { getAccounts().remove(result); }
		return result;
	}
	
	/**
	 * Searches for account by accountNumber argument
	 * 
	 * @param accountNumber unique account number
	 * @return array of accounts
	 */
	public Account searchByAccountNumber(String accountNumber) {
		if (accountNumber != null && accountNumber.length() != 0) {
			for (Account acc : getAccounts()) {
		    	if (acc.getAccountNumber().equals(accountNumber)) {
		    		return acc;
		    	}
		    }
		}
		
	    return null;
	}
	
	/**
	 * Searches for all accounts that have the same accountName argument
	 * 
	 * @param accountName account full name
	 * @return array of accounts
	 */
	public Account[] searchByAccountName(String accountName) {
	    ArrayList<Account> result = new ArrayList<>();
	
	    if (accountName != null && accountName.length() != 0) {
	    	for (Account acc : getAccounts()) {
		    	if (acc.getFullName().equals(accountName)) {
		    		result.add(acc);
		    	}
		    }
	    }
	
	    return result.toArray(new Account[result.size()]);
	}
	
	/**
	 * Searches for all accounts that have the same balance argument
	 * 
	 * @param balance account balance
	 * @return array of accounts
	 */
	public Account[] searchByBalance(BigDecimal balance) {
	    ArrayList<Account> result = new ArrayList<Account>();
	
	    if (balance != null) {
	    	for (Account acc : getAccounts()) {
		    	if (acc.getBalance().compareTo(balance) == 0) {
		    		result.add(acc);
		    	}
		    }
	    }
	
	    return result.toArray(new Account[result.size()]);
	}

	/** @return list of accounts in the bank */
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		result.append("*** Welcome to the Bank of ")
			.append(getName())
			.append(" ***\nIt has ")
			.append(getAccounts().size())
			.append(" account(s)\n");
		
		for (int i = 0; i < getAccounts().size(); i++) {
			result.append((i + 1) + ". " + getAccounts().get(i) + "\n");
		}
		    
		return result.toString();
	}

	/**
	 * Compare to another Bank. Two banks are equal if having the
	 * same name and sequences of accounts. If bank argument is
	 * null, return false
	 * 
	 * @param bank another bank to be compared to
	 * @return result of the comparison
	 */
	public boolean equals(Object obj) {
		Bank bank = obj instanceof Bank ? (Bank) obj : null;
		    
		return bank != null
			&& bank.getName().equals(getName())
	    	&& bank.getAccounts().equals(getAccounts());
	}
}
