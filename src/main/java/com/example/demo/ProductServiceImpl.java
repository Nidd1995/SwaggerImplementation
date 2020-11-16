package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

   private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private  ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        logger.info("Inside createProduct service");
     productRepository.save(product);

    }
}
