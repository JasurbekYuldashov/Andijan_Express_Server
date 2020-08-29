package com.example.demo.controller;


import com.example.demo.models.CategorySecond;
import com.example.demo.repository.CategorySecondRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoryType")
@CrossOrigin
public class CategoryTypeController {
    private final CategorySecondRepository categorySecondRepository;

    public CategoryTypeController(CategorySecondRepository categorySecondRepository) {
        this.categorySecondRepository = categorySecondRepository;
    }

    @GetMapping("/get")
    public ResponseEntity get(){
        List<CategorySecond> categorySeconds = categorySecondRepository.findAllByDeletedFalse();
        return ResponseEntity.ok(categorySeconds);
    }

    @GetMapping("/d/{id}")
    public ResponseEntity del(@PathVariable Integer id){
        categorySecondRepository.deleteById(id);
        List<CategorySecond> categorySeconds = categorySecondRepository.findAllByDeletedFalse();
        return ResponseEntity.ok(categorySeconds);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody CategorySecond categorySecond){
        categorySecondRepository.save(categorySecond);
        List<CategorySecond> categorySeconds = categorySecondRepository.findAllByDeletedFalse();
        return ResponseEntity.ok(categorySeconds);
    }


}
