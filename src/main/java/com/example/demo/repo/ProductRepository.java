package com.example.demo.repo;

import com.example.demo.binding.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Serializable> {
    List<Product> findBySubcategory(String subcategoria);

}
