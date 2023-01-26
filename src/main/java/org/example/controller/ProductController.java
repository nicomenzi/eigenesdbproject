package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Operation(summary = "Find all products")
    @GetMapping
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Operation(summary = "Find product by id")
    @GetMapping("/{id}")
    public Product findById(@PathVariable int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Operation(summary = "Save product")
    @PostMapping
    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @Operation(summary = "Update product")
    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product product) {
        product.setProductId(id);
        return productRepository.save(product);
    }

    @Operation(summary = "Delete product by id")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        productRepository.deleteById(id);
    }
}
