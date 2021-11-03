package com.tutorialspoint.demo.repo;

import com.tutorialspoint.demo.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
