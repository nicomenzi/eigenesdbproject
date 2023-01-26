package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Find all addresses")
    @GetMapping
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Operation(summary = "Find address by id")
    @GetMapping("/{id}")
    public Address findById(@PathVariable int id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Operation(summary = "Save address")
    @PostMapping
    public Address save(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    @Operation(summary = "Update address")
    @PutMapping("/{id}")
    public Address update(@PathVariable int id, @RequestBody Address address) {
        address.setAddressId(id);
        return addressRepository.save(address);
    }

    @Operation(summary = "Delete address by id")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        addressRepository.deleteById(id);
    }
}
