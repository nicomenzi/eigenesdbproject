package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Operation(summary = "Find all customers")
    @GetMapping
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Operation(summary = "Find customer by id")
    @GetMapping("/{id}")
    public Customer findById(@PathVariable Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Operation(summary = "Save customer")
    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @Operation(summary = "Update customer")
    @PutMapping("/{id}")
    public Customer update(@PathVariable int id, @RequestBody Customer customer) {
        customer.setCustomerId(id);
        return customerRepository.save(customer);
    }

    @Operation(summary = "Delete customer by id")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        customerRepository.deleteById(id);
    }
}
