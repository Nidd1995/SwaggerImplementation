package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return  productRepository.findAll();

    }

    public void save(MultipartFile file) {

        try{

            List<Product> productList = ExcelHelper.excelToProduct(file.getInputStream());
              productRepository.saveAll(productList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
