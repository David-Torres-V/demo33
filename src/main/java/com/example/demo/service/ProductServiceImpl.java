package com.example.demo.service;

import com.example.demo.binding.Product;
import com.example.demo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public String upsert(Product product) {
        productRepository.save(product);
        return "success";
    }

    @Override
    public Product getByUrl(String url) {
        Optional<Product> product = productRepository.findById(url);

        if(product.isPresent()){
            return product.get();
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsBySubcategoria(String subcategoria) {
        return productRepository.findBySubcategory(subcategoria);
    }

}
