package ch.roones.uebungen._04fourthday.service;

import ch.roones.uebungen._04fourthday.repository.Address;
import ch.roones.uebungen._04fourthday.repository.AddressRepository;
import ch.roones.uebungen._04fourthday.util.AddressComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddressServiceTest {

    @Mock
    AddressRepository addressRepository;

    @InjectMocks
    AddressService addressService;

    Address a1, a2, a3;

    @BeforeEach
    void init() {
        a1 = new Address(1, "Anna", "Zeta", "0791111111", new Date(0));
        a2 = new Address(2, "Max", "Mustermann", "0792222222", new Date(0));
        a3 = new Address(3, "Bernd", "Alpha", "0793333333", new Date(0));
    }

    @Test
    @DisplayName("save() delegates to repository and returns saved entity")
    void save_shouldDelegateToRepository() {
        when(addressRepository.save(any(Address.class))).thenReturn(a1);

        Address result = addressService.save(a1);

        assertThat(result).isSameAs(a1);
    }

    @Test
    @DisplayName("getAll() should return addresses sorted by comparator")
    void getAll_shouldReturnSortedList() {
        // unsortierte Liste aus dem Repository
        when(addressRepository.findAll()).thenReturn(Arrays.asList(a1, a2, a3));

        List<Address> result = addressService.getAll();

        // Comparator sortiert hier nach deiner Implementierung
        assertThat(result).hasSize(3);
        assertThat(result).isSortedAccordingTo(new AddressComparator());
    }

    @Test
    @DisplayName("getAddress() returns entity if found")
    void getAddress_found() {
        when(addressRepository.findById(1)).thenReturn(Optional.of(a1));

        Optional<Address> result = addressService.getAddress(1);

        assertThat(result).contains(a1);
    }

    @Test
    @DisplayName("getAddress() returns empty if not found")
    void getAddress_notFound() {
        when(addressRepository.findById(99)).thenReturn(Optional.empty());

        Optional<Address> result = addressService.getAddress(99);

        assertThat(result).isEmpty();
    }
}
