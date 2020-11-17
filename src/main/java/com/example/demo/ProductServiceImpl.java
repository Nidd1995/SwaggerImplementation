package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public void getProduct(Integer id) {
      logger.info("Result " +  productRepository.findById(id).toString());

    }

    @Override
    public void updateProduct(Integer id, Product product) {
      logger.info("Inside updateProduct service");
      productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
     logger.info("Inside delete product service");
     Optional<Product> product =   productRepository.findById(id);
//     product.ifPresent()
//      productRepository.delete(product);
    }
}
