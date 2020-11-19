package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/Product")
public class UpdateController {

    private static  final Logger log =  LoggerFactory.getLogger(UpdateController.class);
    @RequestMapping( value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity updateProductController(@PathVariable Integer id){
        log.info("inside unirest call to update controller");
        return  new ResponseEntity("success", HttpStatus.OK);
    }

}
