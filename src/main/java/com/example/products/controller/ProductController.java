package com.example.products.controller;

import com.example.products.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;



}
