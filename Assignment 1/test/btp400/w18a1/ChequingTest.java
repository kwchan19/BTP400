
package test.btp400.w18a1;


import java.math.BigDecimal;


import org.finance.accounts.Chequing;


import junit.framework.TestCase;


public class ChequingTest extends TestCase {

	private Chequing test1, test2, test3;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		test1 = new Chequing("Apetov Jean", "test1234", "1000.00", "0.25");
		test3 = new Chequing("Apetov Jean", "test1234", "1000.00", "0.25");
		test2 = new Chequing();
	}
	
	public void testChequing() {
		
		assertEquals(test2.getFullName(), "");
		assertEquals(test2.getAccountNumber(), "");
		assertTrue(test2.getAccountBalance().compareTo(new BigDecimal(0.0)) == 0);
	}
	
	public void testChequing2() {
		
		assertEquals(test1.getFullName(), "Apetov Jean");
		assertEquals(test1.getAccountNumber(), "test1234");
		assertTrue(test1.getAccountBalance().compareTo(new BigDecimal(1000)) == 0);
	}
	
	
	public void testToEquals() {

		assertEquals(test1.getFullName(), test3.getFullName());
		assertEquals(test1.getAccountNumber(), test3.getAccountNumber());
		assertEquals(test1.getAccountBalance(), test3.getAccountBalance());
	}
	
	
	
	public void testDeposit() {
		
		BigDecimal value1, value2;
		test1.deposit(new BigDecimal(500.00));
		
		value1 = test1.getAccountBalance();
		value2 = new BigDecimal(1500.00);
		
		assertTrue(value1.compareTo(value2) == 0);
	}
	

	

}