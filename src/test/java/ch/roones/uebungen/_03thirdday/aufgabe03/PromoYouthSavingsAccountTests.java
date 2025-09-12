package ch.roones.uebungen._03thirdday.aufgabe03;

import ch.roones.uebungen._03thirdday.aufgabe03.PromoYouthSavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Tests für das Promo-Jugend-Sparkonto.
 *
 * @author XXXX
 * @version 1.0
 */
public class PromoYouthSavingsAccountTests
{

	@Test
	public void testDepositWithBonus() {
		PromoYouthSavingsAccount account = new PromoYouthSavingsAccount("youth-1");
		long depositAmount = 10000; // e.g. 100.00 CHF in Millirappen
		int date = 1;
		boolean result = account.deposit(date, depositAmount);
		assertEquals(true, result, "Deposit should succeed");
		// 1% bonus = 100
		assertEquals(10100, account.getBalance(), "Balance should include 1% bonus");
	}

	@Test
	public void testNegativeDeposit() {
		PromoYouthSavingsAccount account = new PromoYouthSavingsAccount("youth-2");
		int date = 1;
		boolean result = account.deposit(date, -5000);
		assertEquals(false, result, "Negative deposit should fail");
		assertEquals(0, account.getBalance(), "Balance should remain 0 after failed deposit");
	}
}
