package com.example.demo.controller;

import com.example.demo.models.LikeProducts;
import com.example.demo.models.Product;
import com.example.demo.models.dao.ProductDao;
import com.example.demo.repository.LikeProductsRepository;
import com.example.demo.service.LikeProductsService;
import com.example.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeProductsController {
    private final LikeProductsService likeProductsService;
    private final ProductService productService;

    public LikeProductsController(LikeProductsRepository likeProductsRepository, LikeProductsService likeProductsService, ProductService productService) {
        this.likeProductsService = likeProductsService;
        this.productService = productService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable Integer id){
        List<LikeProducts> likeProducts = likeProductsService.getAll(id);
        List<Product> products = productService.get();
        List<ProductDao> productDaos = new ArrayList<>();
        for (int i = 0; i < likeProducts.size(); i++) {
            for (int j = 0; j < products.size(); j++) {
                if (likeProducts.get(i).getProductId()==products.get(j).getId()){
                    ProductDao productDao = new ProductDao();
                    productDao.setLikeProducts(likeProducts.get(i));
                    productDao.setLike(true);
                    productDao.setProduct(products.get(j));
                    productDaos.add(productDao);
                    break;
                }
            }
        }
        return ResponseEntity.ok(productDaos);
    }

    @PostMapping("/save/{id}")
    public ResponseEntity save(@RequestBody LikeProducts likeProducts,@PathVariable Integer id){
        likeProductsService.save(likeProducts);
        List<LikeProducts> likeProducts1 = likeProductsService.getAll(id);
        return ResponseEntity.ok(likeProducts1);
    }

    @GetMapping("d/{id}/{userId}")
    public ResponseEntity delete(@PathVariable Integer id,@PathVariable Integer userId){
        likeProductsService.delete(id);
        List<LikeProducts> likeProducts1 = likeProductsService.getAll(userId);
        return ResponseEntity.ok(likeProducts1);
    }
}
