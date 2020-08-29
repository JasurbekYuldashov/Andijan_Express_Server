package com.example.demo.controller;

import com.example.demo.models.LikeProducts;
import com.example.demo.models.Product;
import com.example.demo.repository.LikeProductsRepository;
import com.example.demo.service.LikeProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeProductsController {
    private final LikeProductsService likeProductsService;

    public LikeProductsController(LikeProductsRepository likeProductsRepository, LikeProductsService likeProductsService) {
        this.likeProductsService = likeProductsService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable Integer id){
        List<LikeProducts> likeProducts = likeProductsService.getAll(id);
        return ResponseEntity.ok(likeProducts);
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
