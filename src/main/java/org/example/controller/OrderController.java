package org.example.controller;

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

    @GetMapping
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Order save(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order order) {
        order.setOrderId(id);
        return orderRepository.save(order);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        orderRepository.deleteById(id);
    }
}
