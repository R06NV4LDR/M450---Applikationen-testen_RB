package ch.roones.uebungen.firstday;

/**
 * PriceCalculator calculates Car prices based on various parameters.
 */
    public class PriceCalculator {

        double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
            double addon_discount;
            double result;

            if (extras >= 5)
                addon_discount = 10;      // <== hier steckt der Bug (10% statt 15%)
            else if (extras >= 3)
                addon_discount = 15;      // <== Reihenfolge ist auch verdreht
            else
                addon_discount = 0;

            if (discount > addon_discount)
                addon_discount = discount;

            result = baseprice / 100.0 * (100 - discount) + specialprice
                    + extraprice / 100.0 * (100 - addon_discount);

            return result;
        }
    }
