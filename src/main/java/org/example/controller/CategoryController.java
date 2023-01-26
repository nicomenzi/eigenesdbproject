package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.model.Category;
import org.example.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;



    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Operation(summary = "Find all categories")
    @GetMapping
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Operation(summary = "Find category by id")
    @GetMapping("/{id}")
    public Category findById(@PathVariable int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Operation(summary = "Save category")
    @PostMapping
    public Category save(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @Operation(summary = "Update category")
    @PutMapping("/{id}")
    public Category update(@PathVariable int id, @RequestBody Category category) {
        category.setCategoryId(id);
        return categoryRepository.save(category);
    }

    @Operation(summary = "Delete category by id")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        categoryRepository.deleteById(id);
    }
}
