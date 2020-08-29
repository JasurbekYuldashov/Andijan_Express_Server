package com.example.demo.service;

import com.example.demo.models.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> get(){
        return productRepository.findAllByDeletedFalse();
    }
    public List<Product> find(String string){
        return productRepository.findAllByDescriptionLike(string);
    }
    public List<Product> getByCategoryId(Integer id){
        return productRepository.findAllByCategoryId(id);
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public void delete(Integer id){
        productRepository.deleteById(id);
    }
}
