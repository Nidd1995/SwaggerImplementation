package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProductController {

    @Autowired
    private ProductService productService;

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @RequestMapping
    public ResponseEntity createProduct(@RequestBody  Product product) {

        log.info("Inside create product controller");
        productService.createProduct(product);
        return new ResponseEntity("successfully created product", HttpStatus.OK);
    }

//    @RequestMapping
//    public ResponseEntity getProduct() {
//
//
//        return new ResponseEntity("successfully fetched product", HttpStatus.OK);
//    }
//
//    @RequestMapping
//    public ResponseEntity updateProduct() {
//
//
//     return new ResponseEntity("product updated", HttpStatus.OK);
//    }
//
//    @RequestMapping
//    public ResponseEntity deleteProduct() {
//
//        return new ResponseEntity("product deleted", HttpStatus.OK);
//    }

}