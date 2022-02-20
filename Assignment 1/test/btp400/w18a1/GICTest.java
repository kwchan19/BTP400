
package test.btp400.w18a1;


import java.math.BigDecimal;


import org.finance.accounts.GIC;
import junit.framework.TestCase;

public class GICTest extends TestCase {

	private GIC test1, test2, test3;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		test1 = new GIC("Apetov Jean", "test1234", "999.00", 4, "0.5");
		test3 = new GIC("Apetov Jean", "test1234", "999.00", 4, "0.5");
		test2 = new GIC();
	}
	
	public void testChequing() {
		
		assertEquals(test2.getFullName(), "");
		assertEquals(test2.getAccountNumber(), "");
		assertTrue(test2.getAccountBalance().compareTo(new BigDecimal(0.0)) == 0);
	}
	
	public void testChequing2() {
		
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
		
		test1.withdraw(new BigDecimal(500.00));
		assertTrue(test1.getAccountBalance().compareTo(new BigDecimal(999)) == 0);
		
	}
	
	public void testDeposit() {
		
		test1.deposit(new BigDecimal(1000.00));
		assertTrue(test1.getAccountBalance().compareTo(new BigDecimal(999)) == 0);
	}
	
	
	
	
	
}