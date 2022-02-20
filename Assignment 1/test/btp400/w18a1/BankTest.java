
package test.btp400.w18a1;


import com.little.bank.Bank;

import org.finance.accounts.Account;



import junit.framework.TestCase;

public class BankTest extends TestCase {

	private Bank test1, test2, test3;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		test1 = new Bank("Apetov Jean");
		test3 = new Bank("Apetov Jean");
		test2 = new Bank();
	}
	
	public void testBank() {
		
		assertEquals(test2.bankName(), "Seneca@York");
		assertEquals(test2.getAllAccounts().length, 0);
		assertEquals(test1.getAllAccounts().length, 0);
		assertEquals(test3.getAllAccounts().length, 0);
	}
	
	public void testBankArray() {
		Account acc = new Account("John Smith","A12345","999.99");
		
		test1.addAccount(acc);
		
		assertEquals(test1.getAllAccounts().length, 1);
		
		
	}
	

	public void testToEquals() {

		assertEquals(test1.bankName(), test3.bankName());
	}
	
	
	
}
