package com.example.demo.rest;

import com.example.demo.binding.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/productos/{url}")
    public ResponseEntity<Product> getProductByUrl(@PathVariable("url") String url){
        return new ResponseEntity<Product>(productService.getByUrl(url), HttpStatus.OK);
    }

    @GetMapping("/productos/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<List<Product>>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/subcategoria/{subcategoria}")
    public ResponseEntity<List<Product>> getProductsBySubcategoria(@PathVariable String subcategoria) {
        List<Product> productos = productService.getProductsBySubcategoria(subcategoria);
        return ResponseEntity.ok(productos);
    }




}
