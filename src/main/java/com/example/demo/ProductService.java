package com.example.demo;


public interface ProductService {

    void createProduct(Product product);

    void getProduct(Integer id);

    void updateProduct(Integer id, Product product);

    void deleteProduct(Integer id);
}
