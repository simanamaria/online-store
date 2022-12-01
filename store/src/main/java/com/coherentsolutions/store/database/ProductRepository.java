package com.coherentsolutions.store.database;

import com.coherentsolutions.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findById(int id);
}
