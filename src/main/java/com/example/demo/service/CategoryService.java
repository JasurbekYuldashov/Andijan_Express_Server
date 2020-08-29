package com.example.demo.service;


import com.example.demo.models.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> get(){
        return categoryRepository.findAllByDeletedFalse();
    }

    public void save(Category category){
        categoryRepository.save(category);
    }

    public void delete(Integer id){
        categoryRepository.deleteById(id);
    }


}
