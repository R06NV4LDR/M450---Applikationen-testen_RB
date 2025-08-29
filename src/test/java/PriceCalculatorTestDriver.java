import ch.roones.uebungen._01firstday.PriceCalculator;

public class PriceCalculatorTestDriver {

    private static boolean nearlyEquals(double a, double b, double epsilon) {
        return Math.abs(a - b) < epsilon;
    }

    private static int failures = 0;

    private static void checkEquals(String name, double expected, double actual) {
        if (!nearlyEquals(expected, actual, 1e-6)) {
            failures++;
            System.err.println(name + " FAILED  expected=" + expected + "  actual=" + actual
                    + "  diff=" + (actual - expected));
        } else {
            System.out.println(name + " passed (" + actual + ")");
        }
    }

    public static void main(String[] args) {
        // >>>> HINWEIS: benutze die **korrigierte** calculatePrice-Implementierung (>=5 vor >=3, keine Vermischung der Rabatte)!
        // Beispiele:
        double t1 = PriceCalculator.calculatePrice(20000, 1000, 3000, 0, 5);
        checkEquals("T1", 23000.0, t1);

        double t2 = PriceCalculator.calculatePrice(20000, 1000, 3000, 3, 5);
        checkEquals("T2", 22700.0, t2);

        double t3 = PriceCalculator.calculatePrice(20000, 1000, 3000, 5, 5);
        checkEquals("T3", 22550.0, t3);

        double t4 = PriceCalculator.calculatePrice(20000, 1000, 3000, 5, 20);
        checkEquals("T4", 19550.0, t4);

        double t5 = PriceCalculator.calculatePrice(1000, 0, 1000, -2, -10);
        checkEquals("T5", 2000.0, t5);

        double t6 = PriceCalculator.calculatePrice(1000, 100, 1000, 10, 150);
        checkEquals("T6", 950.0, t6);

        if (failures > 0) {
            System.err.println("\nTests FAILED: " + failures + " case(s)");
            System.exit(1); // Gradle meldet dann korrekt einen Fehlschlag
        } else {
            System.out.println("\nAll tests passed ✅");
            System.exit(0);
        }
    }
}