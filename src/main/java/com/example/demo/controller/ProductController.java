package com.example.demo.controller;


import com.example.demo.models.Product;
import com.example.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    public final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get")
    public ResponseEntity get(){
        List<Product> productList = productService.get();
        return ResponseEntity.ok(productList);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getById(@PathVariable Integer id){
        List<Product> productList = productService.getByCategoryId(id);
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/gett/{name}")
    public ResponseEntity getById(@PathVariable String name){
        List<Product> productList = productService.find(name);
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/d/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        productService.delete(id);
        List<Product> productList = productService.get();
        return ResponseEntity.ok(productList);
    }
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product){
        productService.save(product);
        List<Product> productList = productService.get();
        return ResponseEntity.ok(productList);
    }

}
