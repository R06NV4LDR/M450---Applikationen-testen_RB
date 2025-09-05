package ch.roones.uebungen._03thirdday.aufgabe03;

import ch.roones.uebungen._03thirdday.aufgabe03.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests f�r die Klasse 'Bank'.
 *
 * @author xxxx
 * @version 1.0
 */
public class BankTests {
        Bank cs = new Bank();
        String id1 = cs.createSavingsAccount();
        String id2 = cs.createPromoYouthSavingsAccount();
        String id3 = cs.createSalaryAccount(100000L);

        Bank zkb = new Bank();
        String b1 = zkb.createSavingsAccount();



    /**
     * Tests to create new Accounts
     */
    @Test
    public void testCreate() {
        assertNotNull(id1);
        assertNotNull(id2);
        //  assertEquals(100000,100000);

        assertNotEquals(id1, id2);
        assertNotEquals(id1, id3);
        assertNotEquals(id2, id3);
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    public void testDeposit() {

        zkb.deposit(b1, 20048, 10000L);
        zkb.deposit(b1, 20049, 25000L);
        zkb.deposit(b1, 20050, 30000L);
        assertEquals(65000L, zkb.getBalance(b1));
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {
        Bank yuh = new Bank();
        String c1 = yuh.createSavingsAccount();
        yuh.deposit(c1, 20033, 10000L);
        boolean ok = yuh.withdraw(c1, 20034, 5000L);
    }


    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        Bank akb = new Bank();
        String d1 = akb.createSavingsAccount();
        akb.deposit(d1, 20000, 10000L);
        akb.deposit(d1, 20001, 25000L);
        akb.deposit(d1, 20002, 30000L);
        akb.withdraw(d1, 20005, 15000L);
        akb.print(d1);
    }

    /**
     * Experimente mit print(year, month).
     */
    @Test
    public void testMonthlyPrint() {
        Bank cler = new Bank();
        String e1 = cler.createSavingsAccount();
        cler.deposit(e1, 20000, 250000L);  //
        cler.deposit(e1, 20001, 100000L);  // 1000.00 am 01.01.2020
        cler.withdraw(e1, 20002, 50000L);   // 500.00 am 02.01.2020
        cler.deposit(e1, 20032, 20000L);   // 200.00 am 01.02.2020
        cler.withdraw(e1, 20033, 15000L);  // 150.00 am 02.02.2020
        cler.print(e1, 2020, 1);
        cler.print(e1, 2020, 2);
    }

    /**
     * Testet den Gesamtkontostand der Bank.
     */
    @Test
    public void testBalance() {
        fail("toDo");
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testTop5() {
        fail("toDo");
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testBottom5() {
        fail("toDo");
    }

}
