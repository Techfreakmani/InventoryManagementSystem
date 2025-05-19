package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProducts")
    public ResponseEntity<String> addProduct(
            @RequestParam String name,
            @RequestParam double price,
            @RequestParam int quantity,
            @RequestParam String category,
            @RequestParam("image") MultipartFile imageFile) {

        try {
            productService.saveProduct(name, price, quantity, category, imageFile);
            return ResponseEntity.ok("Product added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding product.");
        }
    }
}