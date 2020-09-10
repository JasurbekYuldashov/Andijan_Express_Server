package com.example.demo.controller;


import com.example.demo.models.Product;
import com.example.demo.models.dao.ProductDao;
import com.example.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity get() {
        List<Product> productList = productService.get();
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/search/{str}")
    public ResponseEntity searchByStr(@PathVariable String str) {
        List<Product> productList = productService.get();
        List<Product> products = new ArrayList<>();
        List<String> searchString = new ArrayList<>();
        str += " ";
        String string1 = "";
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            if (s != ' ') {
                string1 += s;
            } else {
                searchString.add(string1);
                string1 = "";
            }
        }
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            for (int j = 0; j < searchString.size(); j++) {
                if (product.getDescription().toLowerCase().indexOf(searchString.get(j).toLowerCase()) >= 0 || product.getName().toLowerCase().indexOf(searchString.get(j).toLowerCase()) >= 0) {
                    products.add(product);
                    break;
                }
            }
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        List<Product> productList = productService.getByCategoryId(id);
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/get/user/{id}/categoryId/{categoryId}")
    public ResponseEntity getUserId(@PathVariable Integer id, @PathVariable Integer categoryId) {
        List<ProductDao> productDaoList = productService.getUserProducts(id, categoryId);
        return ResponseEntity.ok(productDaoList);
    }

    @GetMapping("/gett/{name}")
    public ResponseEntity getById(@PathVariable String name) {
        List<Product> productList = productService.find(name);
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/d/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        productService.delete(id);
        List<Product> productList = productService.get();
        return ResponseEntity.ok(productList);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product) {
        productService.save(product);
        List<Product> productList = productService.get();
        return ResponseEntity.ok(productList);
    }

}
