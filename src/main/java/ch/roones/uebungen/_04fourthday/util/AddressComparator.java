package ch.roones.uebungen._04fourthday.util;

import ch.roones.uebungen._04fourthday.repository.Address;

import java.util.Comparator;

public class AddressComparator implements Comparator<Address> {

    private static final Comparator<String> STRING_COMPARATOR = Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER);

    @Override
    public int compare(Address a1, Address a2) {
        if (a1 == a2) return 0;
        if (a1 == null) return 1;
        if (a2 == null) return -1;
        // Wrong implementation, please change me
        return Comparator.comparing(Address::getLastname, STRING_COMPARATOR)
                .thenComparing(Address::getFirstname, STRING_COMPARATOR)
                .thenComparing(Address::getPhonenumber, STRING_COMPARATOR)
                .compare(a1, a2);
    }

}
