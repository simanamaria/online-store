package com.coherentsolutions.store.database;

import com.coherentsolutions.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/products")
public class ProductController {
        private final ProductRepository productRepository;

        public ProductController(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }
        @GetMapping
        public Iterable findAll(){
            return productRepository.findAll();
        }
        @GetMapping("/findBy")
        public Product findById(@RequestParam int id) {
            return productRepository.findById(id);
        }


}

