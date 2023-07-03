package com.example.demo.service;

import com.example.demo.binding.Product;

import java.util.List;

public interface ProductService {

    public String upsert(Product product);

    public Product getByUrl(String url);

    public List<Product> getAll();

    public List<Product> getProductsBySubcategoria(String subcategoria);

}
