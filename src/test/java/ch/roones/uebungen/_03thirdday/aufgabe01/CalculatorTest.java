package ch.roones.uebungen._03thirdday.aufgabe01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-1, calculator.add(-2, 1));
        assertEquals(0, calculator.add(0, 0));
    }

    @Test
    public void testSubtract() {
        assertEquals(-1, calculator.subtract(2, 3));
        assertEquals(-3, calculator.subtract(-2, 1));
        assertEquals(0, calculator.subtract(0, 0));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(-2, calculator.multiply(-2, 1));
        assertEquals(0, calculator.multiply(0, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(-2, calculator.divide(-6, 3));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(5, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @Test
    public void testModulus() {
        assertEquals(1, calculator.modulus(7, 3));
        assertEquals(-1, calculator.modulus(-7, 3));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.modulus(5, 0);
        });
        assertEquals("Modulus by zero is not allowed.", exception.getMessage());
    }

    @Test
    public void testPower() {
        assertEquals(8, calculator.power(2, 3));
        assertEquals(1, calculator.power(5, 0));
        assertEquals(0.25, calculator.power(2, -2));
    }

    @Test
    public void testSqrt() {
        assertEquals(3, calculator.sqrt(9));
        assertEquals(0, calculator.sqrt(0));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.sqrt(-4);
        });
        assertEquals("Square root of negative number is not allowed.", exception.getMessage());
    }


}
