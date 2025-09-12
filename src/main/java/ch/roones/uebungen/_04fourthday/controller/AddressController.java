package ch.roones.uebungen._04fourthday.controller;

import ch.roones.uebungen._04fourthday.repository.Address;
import ch.roones.uebungen._04fourthday.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        return ResponseEntity.status(201).body(addressService.save(address));
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAddresses() {
        return ResponseEntity.status(200).body(addressService.getAll());
    }

    @GetMapping("/{address_id}")
    public ResponseEntity<Address> getAddress(@PathVariable("address_id") int addressId) {
        Optional<Address> address = addressService.getAddress(addressId);

        return address
                .map(value -> ResponseEntity.status(200).body(value))
                .orElseGet(() -> ResponseEntity.status(404).build());
    }
}
