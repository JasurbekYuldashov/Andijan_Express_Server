package com.example.demo.models.dao;

import com.example.demo.models.Product;
import com.example.demo.models.Users;
import lombok.Data;

@Data
public class UserDto {
    private Users user;
    private Product product;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
