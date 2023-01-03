package com.kafka.poc1.controllers;

import com.kafka.poc1.model.Product;
import com.kafka.poc1.services.KafkaSender;
import com.kafka.poc1.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private ProductService productService;

    @Autowired
    private KafkaSender kafkaSender;

    @GetMapping("/product")
    Product findById(@RequestParam("pid") int id){
        var res = productService.findById(id);
        return res;
    }

    @PostMapping("/product/create")
    Product createProduct(@RequestParam("pid")int id, @RequestParam("pname")String name){
        var res = productService.saveProduct(id,name);
        System.out.println(kafkaSender.sendMessage(res));
        return res;
    }
}
