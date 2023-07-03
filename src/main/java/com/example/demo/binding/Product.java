package com.example.demo.binding;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String characteristics;
    private Double price;
    private String productKeys;
    private String url;
    private String category;
    private String subcategory;
}
