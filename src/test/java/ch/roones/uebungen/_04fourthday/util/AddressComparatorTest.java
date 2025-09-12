package ch.roones.uebungen._04fourthday.util;

import ch.roones.uebungen._04fourthday.repository.Address;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressComparatorTest {
    @Test
    void ordersByLastnameThenFirstnameThenId_nullsLast_caseInsensitive() {
        Date d = new Date(0);
        Address a = new Address(2, "max", "mustermann", "1", d);
        Address b = new Address(1, "Anna", "Mustermann", "2", d); // same lastname, firstname decides
        Address c = new Address(3, "Zoe", "Alpha", "3", d);       // lastname 'Alpha' first
        Address dNull = new Address(4, "X", null, "4", d);        // null lastname -> last

        List<Address> list = new ArrayList<>(List.of(a, b, c, dNull));
        list.sort(new AddressComparator());

        // Expected order: c (Alpha), b (Mustermann, Anna), a (Mustermann, max), dNull (null lastname)
        assertThat(list).extracting(Address::getId).containsExactly(3, 1, 2, 4);
    }
}
