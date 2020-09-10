package com.example.demo.models.dao;

import com.example.demo.models.LikeProducts;
import com.example.demo.models.Product;

public class ProductDao {
    Product product;
    LikeProducts likeProducts = new LikeProducts();
    Boolean isLike = false;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Boolean getLike() {
        return isLike;
    }

    public LikeProducts getLikeProducts() {
        return likeProducts;
    }

    public void setLikeProducts(LikeProducts likeProducts) {
        this.likeProducts = likeProducts;
    }

    public void setLike(Boolean like) {
        isLike = like;
    }
}
