package ch.roones.uebungen._03thirdday.aufgabe03;

import ch.roones.uebungen._03thirdday.aufgabe03.SavingsAccount;



/**
 * Tests f�r die Klasse SavingsAccount.
 *
 * @author Roger H. J&ouml;rg
 * @version 1.0
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse SavingsAccount.
 *
 * @author XXX
 * @version 1.0
 */
public class SavingsAccountTests
{

	@Test
	public void testDeposit() {
		SavingsAccount account = new SavingsAccount("savings-1");
		boolean result = account.deposit(1, 5000); // deposit 50.00 CHF
		assertTrue(result, "Deposit should succeed");
		assertEquals(5000, account.getBalance(), "Balance should be 5000 after deposit");
	}

	@Test
	public void testWithdrawWithinBalance() {
		SavingsAccount account = new SavingsAccount("savings-2");
		account.deposit(1, 10000);
		boolean result = account.withdraw(2, 4000);
		assertTrue(result, "Withdraw within balance should succeed");
		assertEquals(6000, account.getBalance(), "Balance should be 6000 after withdrawal");
	}

	@Test
	public void testWithdrawOverBalance() {
		SavingsAccount account = new SavingsAccount("savings-3");
		account.deposit(1, 3000);
		boolean result = account.withdraw(2, 4000);
		assertFalse(result, "Withdraw over balance should fail");
		assertEquals(3000, account.getBalance(), "Balance should remain 3000 after failed withdrawal");
	}

	@Test
	public void testNegativeDeposit() {
		SavingsAccount account = new SavingsAccount("savings-4");
		boolean result = account.deposit(1, -1000);
		assertFalse(result, "Negative deposit should fail");
		assertEquals(0, account.getBalance(), "Balance should remain 0 after failed deposit");
	}

	@Test
	public void testNegativeWithdraw() {
		SavingsAccount account = new SavingsAccount("savings-5");
		account.deposit(1, 2000);
		boolean result = account.withdraw(2, -500);
		assertFalse(result, "Negative withdraw should fail");
		assertEquals(2000, account.getBalance(), "Balance should remain 2000 after failed withdrawal");
	}
}

