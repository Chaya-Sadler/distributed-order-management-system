package com.chayasadler.productservice.service;

import com.chayasadler.productservice.dao.IProductRepository;
import com.chayasadler.productservice.model.Product;
import com.chayasadler.productservice.model.ProductRequest;
import com.chayasadler.productservice.model.ProductResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    IProductRepository iProductRepository;

    public ProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    public ResponseEntity<String> createProducts(ProductRequest productRequest) {

        Product product = new Product(productRequest.name(), productRequest.description(), productRequest.price(),
                productRequest.unit(), productRequest.category());
        product.setActive(true);
        iProductRepository.save(product);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ProductResponse getProductById(UUID id) {
        return iProductRepository.findProductById(id);
    }

    public List<ProductResponse> getAllProducts() {
         List<Product> productList = iProductRepository.findAll();
         return productList.stream()
                 .map( p -> new ProductResponse(p.getName(), p.getDescription(), p.getPrice(),
                         p.getUnit(), p.getProductCategory(), p.getActive()))
                 .collect(Collectors.toList());
    }

    public ResponseEntity<String> updateProductById(UUID id, ProductRequest productRequest) {

        Product product = iProductRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(" Product is not found with id : " + id));
        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setProductCategory(productRequest.category());
        product.setPrice(productRequest.price());
        product.setUnit(productRequest.unit());

        iProductRepository.save(product);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteProduct(UUID id) {

        Product product = iProductRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(" Product is not found with id : " + id));

        product.setActive(false);
        product.setUpdateAt(LocalDateTime.now());

        iProductRepository.save(product);

        return new ResponseEntity<>("Success", HttpStatus.OK);

    }
}
