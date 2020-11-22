package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("http://localhost:7200")
@RestController
@RequestMapping("/api/excel")
public class ExcelController {

    @Autowired
    ExcelService excelService;


    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file){

        String message ="";

        if(ExcelHelper.hasExcelFormat(file)){

            try{
                 excelService.save(file);
                 message = "uploaded the file successfully: " + file.getOriginalFilename();
                 return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

            }catch(Exception e){
                message = "file upload failed " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));

    }

 @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllproducts() {

     try {

         List<Product> productList = excelService.getAllProducts();

         if(productList.isEmpty()){
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         }

         return new ResponseEntity<>(productList, HttpStatus.OK);
     }catch (Exception e){
         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
     }
 }

}
