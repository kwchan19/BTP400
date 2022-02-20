
package test.btp400.w18a1;

import java.math.BigDecimal;

import org.finance.accounts.Savings;

import junit.framework.TestCase;

public class SavingsTest extends TestCase {
	
	private Savings test1, test2, test3;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		test1 = new Savings("Apetov Jean", "test1234", "999.00", "0.5");
		test3 = new Savings("Apetov Jean", "test1234", "999.00", "0.5");
		test2 = new Savings();
	}
	

	public void testSavings() { 
		
		assertEquals(test2.getFullName(), "");
		assertEquals(test2.getAccountNumber(), "");
		assertTrue(test2.getAccountBalance().compareTo(new BigDecimal(0.0)) == 0);
	}

	public void testSavings2() {
		
		assertEquals(test1.getFullName(), "Apetov Jean");
		assertEquals(test1.getAccountNumber(), "test1234");
		assertTrue(test1.getAccountBalance().compareTo(new BigDecimal(999.00)) == 0);
	}


	public void testToEquals() {
		
		assertEquals(test1.getFullName(), test3.getFullName());
		assertEquals(test1.getAccountNumber(), test3.getAccountNumber());
		assertEquals(test1.getAccountBalance(), test3.getAccountBalance());
	}

 
	
}