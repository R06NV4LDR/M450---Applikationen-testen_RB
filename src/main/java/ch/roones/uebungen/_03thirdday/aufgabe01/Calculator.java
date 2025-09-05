package ch.roones.uebungen._03thirdday.aufgabe01;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return a / b;
    }

    public double modulus(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Modulus by zero is not allowed.");
        }
        return a % b;
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double sqrt(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Square root of negative number is not allowed.");
        }
        return Math.sqrt(a);
    }
}

