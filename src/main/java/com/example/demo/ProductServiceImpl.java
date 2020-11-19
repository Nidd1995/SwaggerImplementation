package com.example.demo;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
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
        Runtime runtime = Runtime.getRuntime();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("used memory"+ memory/(1024L * 1024L));

    }

    @Override
    public void updateProduct(Integer id, Product product) {
      logger.info("Inside updateProduct service");
        Runtime runtime = Runtime.getRuntime();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("used memory "+ memory/(1024L * 1024L));
      String url = "http://localhost:8080/Product/update/{id}";
      logger.info("url --->>> {} ", url);
      HttpResponse<String> response =  Unirest.post(url)
                                        .header("accept", "application/json")
                                    .routeParam("id", id.toString()).asString();



      if(response != null)
    logger.info(response.toString());
else
    logger.info("response is null");
  //    productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
     logger.info("Inside delete product service");
     Optional<Product> product =   productRepository.findById(id);
//     product.ifPresent()
//      productRepository.delete(product);
    }
}
