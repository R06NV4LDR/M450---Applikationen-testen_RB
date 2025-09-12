package ch.roones.uebungen._04fourthday.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AddressRepositoryTest {

    @Autowired
    AddressRepository addressRepository;

    Address a1, a2;

    @BeforeEach
    void setUp() {
        a1 = new Address(1, "Max", "Mustermann", "0791234567", new Date(0));
        a2 = new Address(2, "Anna", "Musterfrau", "0789876543", new Date(0));
    }

    @Test
    @DisplayName("save() should persist entity")
    void save_shouldPersistEntity() {
        Address saved = addressRepository.save(a1);

        assertThat(saved.getId()).isEqualTo(1);
        assertThat(saved.getFirstname()).isEqualTo("Max");
        assertThat(saved.getLastname()).isEqualTo("Mustermann");
        assertThat(saved.getPhonenumber()).isEqualTo("0791234567");

        Optional<Address> reloadedOpt = addressRepository.findById(1);
        assertThat(reloadedOpt).isPresent();

        Address reloaded = reloadedOpt.get();
        assertThat(reloaded.getId()).isEqualTo(1);
        assertThat(reloaded.getFirstname()).isEqualTo("Max");
        assertThat(reloaded.getLastname()).isEqualTo("Mustermann");
        assertThat(reloaded.getPhonenumber()).isEqualTo("0791234567");

        // Typ prüfen (wie bei dir):
        assertThat(reloaded.getRegistrationDate()).isInstanceOf(java.sql.Timestamp.class);

        // Inhalt prüfen – eine der beiden Varianten wählen:

        // Variante A: über Instant (empfohlen, TZ-sicher)
        assertThat(reloaded.getRegistrationDate().toInstant()).isEqualTo(Instant.EPOCH);
    }

    @Test
    @DisplayName("findAll() should return all entities")
    void findAll_shouldReturnAll() {
        addressRepository.save(a1);
        addressRepository.save(a2);

        List<Address> all = addressRepository.findAll();

        assertThat(all).hasSize(2);
        // feldbasierte Prüfung
        assertThat(all)
                .extracting(Address::getId, Address::getFirstname, Address::getLastname)
                .containsExactlyInAnyOrder(
                        org.assertj.core.groups.Tuple.tuple(1, "Max", "Mustermann"),
                        org.assertj.core.groups.Tuple.tuple(2, "Anna", "Musterfrau")
                );
    }

    @Test
    @DisplayName("findById() should return Optional with entity")
    void findById_shouldReturnOptional() {
        addressRepository.save(a1);

        Optional<Address> found = addressRepository.findById(1);

        assertThat(found).isPresent();
        Address addr = found.get();
        assertThat(addr.getId()).isEqualTo(1);
        assertThat(addr.getFirstname()).isEqualTo("Max");
    }

    @Test
    @DisplayName("deleteById() should remove entity")
    void deleteById_shouldRemoveEntity() {
        addressRepository.save(a1);
        addressRepository.deleteById(1);

        Optional<Address> found = addressRepository.findById(1);
        assertThat(found).isEmpty();
    }
}
