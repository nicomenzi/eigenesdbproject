package org.example.repository;

import org.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    void deleteById(Long id);
}
