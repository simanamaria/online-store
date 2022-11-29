package com.coherentsolutions.store.database;

import com.coherentsolutions.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/products")
public class ProductController {
        private final ProductRepository productRepository;

        public ProductController(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }
        @GetMapping("/findBy")
        public Product findById(@RequestParam int id) {
            return productRepository.findById(id);
        }
    }

