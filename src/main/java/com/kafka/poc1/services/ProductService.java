package com.kafka.poc1.services;

import com.kafka.poc1.model.Product;
import com.kafka.poc1.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
 public class ProductService implements ProductServiceInterface{

     @Autowired
     private ProductRepository productRepository;

    @Override
    public Product findById(int id) {
        var res = productRepository.findById(id);
        if(res.isEmpty()){
            return new Product();
        }
        return res.get();
    }

    @Override
    public Product saveProduct(int id, String name){
        Product product = new Product(id, name);
        var res = productRepository.save(product);
        return res;

    }
}
