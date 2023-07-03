package com.example.demo.rest;

import com.example.demo.binding.Product;
import com.example.demo.binding.User;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RecommendationRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @PostMapping("/recomendacion")
    public ResponseEntity<Map<String, Object>> getRecommendation(@RequestBody Map<String, String> requestData) {
        String userId = requestData.get("id");
        String subcategory = requestData.get("subcategory");

        User user = userService.getById(Integer.parseInt(userId));
        List<Product> recommendedProducts = productService.getProductsBySubcategoria(subcategory);

        Map<String, Object> response = new HashMap<>();
        response.put("user", user);
        response.put("recommendedProducts", recommendedProducts);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
