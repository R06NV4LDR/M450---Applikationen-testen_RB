package ch.roones.uebungen._03thirdday.aufgabe03;

import ch.roones.uebungen._03thirdday.aufgabe03.SalaryAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests der Klasse SalaryAccount.
 *
 * @author XXX
 * @version 1.1
 */
public class SalaryAccountTests
{

	@Test
	public void testWithdrawWithinCreditLimit() {
		SalaryAccount account = new SalaryAccount("salary-1", -10000); // credit limit -100.00 CHF
		account.deposit(1, 0); // start at 0
		boolean result = account.withdraw(2, 9000); // withdraw 90.00 CHF
		assertTrue(result, "Withdraw within credit limit should succeed");
		assertEquals(-9000, account.getBalance(), "Balance should be -9000 after withdrawal");
	}

	@Test
	public void testWithdrawBeyondCreditLimit() {
		SalaryAccount account = new SalaryAccount("salary-2", -10000); // credit limit -100.00 CHF
		account.deposit(1, 0); // start at 0
		boolean result = account.withdraw(2, 11000); // withdraw 110.00 CHF
		assertFalse(result, "Withdraw beyond credit limit should fail");
		assertEquals(0, account.getBalance(), "Balance should remain 0 after failed withdrawal");
	}

	@Test
	public void testNegativeWithdraw() {
		SalaryAccount account = new SalaryAccount("salary-3", -10000);
		account.deposit(1, 0);
		boolean result = account.withdraw(2, -5000);
		assertFalse(result, "Negative withdraw should fail");
		assertEquals(0, account.getBalance(), "Balance should remain 0 after failed negative withdrawal");
	}
}
