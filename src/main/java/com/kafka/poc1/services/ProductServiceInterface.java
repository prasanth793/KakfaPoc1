package com.kafka.poc1.services;

import com.kafka.poc1.model.Product;
import com.kafka.poc1.repos.ProductRepository;

import java.util.List;

public interface ProductServiceInterface{

     Product findById(int id);

     Product saveProduct(int id, String name);

}
