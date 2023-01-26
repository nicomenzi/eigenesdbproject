package org.example.controller;

import org.example.model.Address;
import org.example.repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable int id) {
        return addressRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Address save(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    @PutMapping("/{id}")
    public Address update(@PathVariable int id, @RequestBody Address address) {
        address.setAddressId(id);
        return addressRepository.save(address);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        addressRepository.deleteById(id);
    }
}
