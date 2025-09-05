package ch.roones.uebungen._03thirdday.aufgabe01;


import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Simple Calculator ===");
        System.out.println("Wählen Sie eine Operation: (+, -, *, /, %, ^, sqrt)");
        String operation = scanner.next();

        double result;

        try {
            if (operation.equals("sqrt")) {
                // Nur eine Eingabe nötig
                System.out.print("Geben Sie eine Zahl ein: ");
                double a = scanner.nextDouble();
                result = calculator.sqrt(a);
            } else {
                // Zwei Eingaben nötig
                System.out.print("Geben Sie die erste Zahl ein: ");
                double a = scanner.nextDouble();
                System.out.print("Geben Sie die zweite Zahl ein: ");
                double b = scanner.nextDouble();

                switch (operation) {
                    case "+":
                        result = calculator.add(a, b);
                        break;
                    case "-":
                        result = calculator.subtract(a, b);
                        break;
                    case "*":
                        result = calculator.multiply(a, b);
                        break;
                    case "/":
                        result = calculator.divide(a, b);
                        break;
                    case "%":
                        result = calculator.modulus(a, b);
                        break;
                    case "^":
                        result = calculator.power(a, b);
                        break;
                    default:
                        System.out.println("Ungültige Operation!");
                        return;
                }
            }

            System.out.println("Ergebnis: " + result);

        } catch (IllegalArgumentException e) {
            System.out.println("Fehler: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
