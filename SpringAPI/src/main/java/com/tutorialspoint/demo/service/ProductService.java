package com.tutorialspoint.demo.service;

import com.tutorialspoint.demo.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProduct();
    void saveProduct(Product product);
    void deleteProduct(Integer id);
    Optional<Product> findProductById(Integer id);

}
