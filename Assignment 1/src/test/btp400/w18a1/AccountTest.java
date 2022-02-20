/**
 * 
 */
package test.btp400.w18a1;


import java.math.BigDecimal;


import org.finance.accounts.Account;

import junit.framework.TestCase;

public class AccountTest extends TestCase {

	private Account test1, test2, test3;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		test1 = new Account("Apetov Jean", "test1234", "999.00");
		test3 = new Account("Apetov Jean", "test1234", "999.00");
		test2 = new Account();
	}
	
	public void testAccount() {
		
		assertEquals(test2.getFullName(), "");
		assertEquals(test2.getAccountNumber(), "");
		assertTrue(test2.getAccountBalance().compareTo(new BigDecimal(0.0)) == 0);
	}
	
	public void testAccount2() {
		
		assertEquals(test1.getFullName(), "Apetov Jean");
		assertEquals(test1.getAccountNumber(), "test1234");
		assertTrue(test1.getAccountBalance().compareTo(new BigDecimal(999)) == 0);
	}
	

	public void testToEquals() {

		assertEquals(test1.getFullName(), test3.getFullName());
		assertEquals(test1.getAccountNumber(), test3.getAccountNumber());
		assertEquals(test1.getAccountBalance(), test3.getAccountBalance());
	}
	
	
	public void testWithdraw() {
		
		test1.withdraw(new BigDecimal(100.00));
		assertTrue(test1.getAccountBalance().compareTo(new BigDecimal(899)) == 0);
		
	}
	
	public void testDeposit() {
		
		test1.deposit(new BigDecimal(500.00));
		assertTrue(test1.getAccountBalance().compareTo(new BigDecimal(1499.0)) == 0);
	}
}
