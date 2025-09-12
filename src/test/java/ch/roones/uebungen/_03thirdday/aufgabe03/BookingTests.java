package ch.roones.uebungen._03thirdday.aufgabe03;

import ch.roones.uebungen._03thirdday.aufgabe03.Booking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


/**
 * Tests für die Klasse Booking.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
public class BookingTests
{
	/**
	 * Tests f�r die Erzeugung von Buchungen.
	 */
	@Test
	public void testInitialization() {
		int date = 1234;
		long amount = 56789L;
		Booking booking = new Booking(date, amount);
		assertEquals(date, booking.getDate(), "Date should be set correctly");
		assertEquals(amount, booking.getAmount(), "Amount should be set correctly");
	}

	/**
	 * Experimente mit print().
	 */
	@Test
	public void testPrint() {
		Booking booking = new Booking(0, 100000); // 1.1.1970, 1.00 CHF
		long balance = 200000; // 2.00 CHF
		// Capture output
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
		System.setOut(new java.io.PrintStream(out));
		booking.print(balance);
		System.setOut(System.out); // reset
		String output = out.toString().trim();
		// Expected: 01.01.1970      1.00      3.00 (with spaces for alignment)
		String expectedDate = "01.01.1970";
		String expectedAmount = BankUtils.formatAmount(100000);
		String expectedNewBalance = BankUtils.formatAmount(300000);
		assertEquals(expectedDate + " " + expectedAmount + " " + expectedNewBalance, output, "Print output should match expected format");
	}
}
