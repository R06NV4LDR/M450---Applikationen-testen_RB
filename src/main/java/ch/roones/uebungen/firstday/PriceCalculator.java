package ch.roones.uebungen.firstday;

public class PriceCalculator {

    /**
     * Calculates the final price of a car based on various parameters.
     * @param baseprice The base price of the car.
     * @param specialprice A special price reduction.
     * @param extraprice The price of additional features. (3–4 → 10%, >=5 → 15%)
     * @param extras The number of additional features.
     * @param discount
     * * @return
     */

    public static double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        if (extras <= 0) extras = 0;
        if (discount < 0) discount = 0;
        if (discount > 100) discount = 100;

        double addon_discount;
        if (extras >= 5) addon_discount = 15.0;
        else if (extras >= 3) addon_discount = 10;
        else addon_discount = 0;

        double basePart = baseprice * (1.0 - discount / 100.0);
        double extraPart = extraprice * (1.0 - addon_discount / 100.0);
        return basePart + specialprice + extraPart;




    }
}
