package ch.roones.uebungen._04fourthday.service;

import ch.roones.uebungen._04fourthday.repository.Address;
import ch.roones.uebungen._04fourthday.util.AddressComparator;
import ch.roones.uebungen._04fourthday.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository =  addressRepository;
    }

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> getAll() {
        return addressRepository.findAll().stream().sorted(new AddressComparator()).toList();
    }

    public Optional<Address> getAddress(int id) {
        return addressRepository.findById(id);
    }
}
