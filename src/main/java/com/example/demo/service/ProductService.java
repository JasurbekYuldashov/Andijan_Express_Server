package com.example.demo.service;

import com.example.demo.models.LikeProducts;
import com.example.demo.models.Product;
import com.example.demo.models.dao.ProductDao;
import com.example.demo.repository.LikeProductsRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final LikeProductsRepository likeProductsRepository;

    public ProductService(ProductRepository productRepository, LikeProductsRepository likeProductsRepository) {
        this.productRepository = productRepository;
        this.likeProductsRepository = likeProductsRepository;
    }

    public List<Product> get() {
        return productRepository.findAllByDeletedFalse();
    }

    public List<ProductDao> getUserProducts(Integer userId,Integer categoryId) {
        List<ProductDao> productDaoList = new ArrayList<>();
        List<Product> products = productRepository.findAllByCategoryId(categoryId);
        List<LikeProducts> likeProducts = likeProductsRepository.findAllByDeletedFalseAndUserId(userId);
        for (int i = 0; i < products.size(); i++) {
            ProductDao productDao = new ProductDao();
            productDao.setProduct(products.get(i));
            for (int j = 0; j < likeProducts.size(); j++) {
                if (likeProducts.get(j).getUserId()==userId && likeProducts.get(j).getProductId()==products.get(i).getId()){
                    productDao.setLike(true);
                    productDao.setLikeProducts(likeProducts.get(j));
                    break;
                }
            }
            productDaoList.add(productDao);
        }
        return productDaoList;
    }

    public List<Product> find(String string) {
        return productRepository.findAllByDescriptionLike(string);
    }

    public List<Product> getByCategoryId(Integer id) {
        return productRepository.findAllByCategoryId(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
