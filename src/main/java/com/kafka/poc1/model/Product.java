package com.kafka.poc1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_source")
public class Product {

    @Id
    @Column
    private Integer id;
    @Column
    private String name;

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
