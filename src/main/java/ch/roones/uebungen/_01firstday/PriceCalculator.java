package ch.roones.uebungen._01firstday;

/**
 * PriceCalculator calculates Car prices based on various parameters.
 */
public class PriceCalculator {

    public static double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        double addon_discount;
        double result;

        if (extras < 0)
            extras = 0;

        if (extras >= 5)
            addon_discount = 15;      // <== hier steckt der Bug (10% statt 15%)
        else if (extras >= 3)
            addon_discount = 10;      // <== Reihenfolge ist auch verdreht
        else
            addon_discount = 0;

        if (discount < 0)
            discount = 0;
        if (discount > 100)
            discount = 100;

        double basePart = baseprice * (1.0 - discount / 100.0);
        double extraPart = extraprice * (1.0 - addon_discount / 100.0);
        return basePart + specialprice + extraPart;
    }
}
