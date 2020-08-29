package com.example.demo.service;


import com.example.demo.models.CategorySecond;
import com.example.demo.repository.CategorySecondRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryTypeService {
    private final CategorySecondRepository categorySecondRepository;

    public CategoryTypeService(CategorySecondRepository categorySecondRepository) {
        this.categorySecondRepository = categorySecondRepository;
    }

    public List<CategorySecond> get(){
        return categorySecondRepository.findAllByDeletedFalse();
    }

    public void save(CategorySecond categorySecond){
        categorySecondRepository.save(categorySecond);
    }

    public void delete(Integer id){
        categorySecondRepository.deleteById(id);
    }

}
