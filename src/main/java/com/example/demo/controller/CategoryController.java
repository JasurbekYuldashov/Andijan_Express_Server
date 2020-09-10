package com.example.demo.controller;

import com.example.demo.models.Category;
import com.example.demo.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    public final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/get")
    public ResponseEntity get() {
        List<Category> categoryList = categoryService.get();
        categoryList.sort(Comparator.comparing(Category::getViews).reversed());
        return ResponseEntity.ok(categoryList);
    }

    @GetMapping("view/{id}")
    public ResponseEntity viewCategory(@PathVariable Integer id) {
        Integer view;
        Optional<Category> category = categoryService.getById(id);
        if (category.get().getViews() != null) {
            view = category.get().getViews();
        } else {
            view = 0;
        }
        category.get().setViews(view + 1);
        categoryService.save(category.get());
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/d/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        categoryService.delete(id);
        List<Category> categoryList = categoryService.get();
        return ResponseEntity.ok(categoryList);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Category category) {
        categoryService.save(category);
        List<Category> categoryList = categoryService.get();
        return ResponseEntity.ok(categoryList);
    }
}
