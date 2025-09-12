package ch.roones.uebungen._04fourthday.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class AddressTest {

    private Address address;
    private Date regDate;

    @BeforeEach
    void setUp() {
        regDate = new Date();
        address = new Address(
                1,
                "Max",
                "Mustermann",
                "0791234567",
                regDate
        );
    }

    @Test
    void constructor_shouldSetAllFields() {
        assertThat(address.getId()).isEqualTo(1);
        assertThat(address.getFirstname()).isEqualTo("Max");
        assertThat(address.getLastname()).isEqualTo("Mustermann");
        assertThat(address.getPhonenumber()).isEqualTo("0791234567");
        assertThat(address.getRegistrationDate()).isEqualTo(regDate);
    }

    @Test
    void settersAndGetters_shouldWork() {
        Date newDate = new Date();

        address.setId(2);
        address.setFirstname("Anna");
        address.setLastname("Musterfrau");
        address.setPhonenumber("0789876543");
        address.setRegistrationDate(newDate);

        assertThat(address.getId()).isEqualTo(2);
        assertThat(address.getFirstname()).isEqualTo("Anna");
        assertThat(address.getLastname()).isEqualTo("Musterfrau");
        assertThat(address.getPhonenumber()).isEqualTo("0789876543");
        assertThat(address.getRegistrationDate()).isEqualTo(newDate);
    }

    @Test
    void noArgsConstructor_shouldCreateEmptyObject() {
        Address empty = new Address();
        empty.setId(3);
        empty.setFirstname("Hans");

        assertThat(empty.getId()).isEqualTo(3);
        assertThat(empty.getFirstname()).isEqualTo("Hans");
    }
}
