package com.chayasadler.productservice.controller;

import com.chayasadler.productservice.model.ProductRequest;
import com.chayasadler.productservice.model.ProductResponse;
import com.chayasadler.productservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/app")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<String> createProducts(@RequestBody ProductRequest product) {
        return productService.createProducts(product);
    }

    @GetMapping("/products/{id}")
    public ProductResponse getProductById(@PathVariable UUID id){
        return productService.getProductById(id);
    }

    @GetMapping("/products")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProductById(@PathVariable UUID id, @RequestBody ProductRequest productRequest) {
        return productService.updateProductById(id, productRequest);
    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<String>  deleteProduct(@PathVariable UUID id) {

        return productService.deleteProduct(id);
    }

}
