package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.model.Order;
import org.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Operation(summary = "Find all orders")
    @GetMapping
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Operation(summary = "Find order by id")
    @GetMapping("/{id}")
    public Order findById(@PathVariable int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Operation(summary = "Save order")
    @PostMapping
    public Order save(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @Operation(summary = "Update order")
    @PutMapping("/{id}")
    public Order update(@PathVariable int id, @RequestBody Order order) {
        order.setOrderId(id);
        return orderRepository.save(order);
    }

    @Operation(summary = "Delete order by id")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        orderRepository.deleteById(id);
    }
}
