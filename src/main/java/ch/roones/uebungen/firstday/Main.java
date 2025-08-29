package ch.roones.uebungen.firstday;
import ch.roones.uebungen.firstday.PriceCalculator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        double car1 = PriceCalculator.calculatePrice(30000, 5000, 2000, 4, 5);
        double car2 = PriceCalculator.calculatePrice(45000, 3000, 4000, 2, 10);
        double car3 = PriceCalculator.calculatePrice(60000, 0, 6000, 5, 0);
        double car4 = PriceCalculator.calculatePrice(10000, 2000, 1000, 1, 20);

        System.out.printf("The price of car1 is: %.2f\n", car1);
        System.out.println("The price of car2 is: " + car2);
        System.out.printf("The price of car3 is: %.2f\n", car3);
        System.out.println("The price of car4 is: " + car4);

    }
}

