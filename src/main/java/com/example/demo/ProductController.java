package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @RequestMapping(value ="/createProduct", method = RequestMethod.POST)
    public ResponseEntity createProduct(@RequestBody  Product product) {

        log.info("Inside create product controller");
        productService.createProduct(product);
        return new ResponseEntity("successfully created product", HttpStatus.OK);
    }

    @RequestMapping(value ="/getProduct/{id}", method = RequestMethod.GET)
    public ResponseEntity getProduct(@PathVariable Integer id) {
    log.info("Inside get product controller");
     productService.getProduct(id);
        return new ResponseEntity("successfully fetched product", HttpStatus.OK);
    }

    @RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product) {

        log.info("Inside  updateproduct controller");
        productService.updateProduct(id, product);
     return new ResponseEntity("product updated", HttpStatus.OK);
    }

    @RequestMapping(value ="/deleteProduct/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        log.info("Inside  deleteproduct controller");
        productService.deleteProduct(id);
        return new ResponseEntity("product deleted", HttpStatus.OK);
    }

}