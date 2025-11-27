package com.chayasadler.productservice.dao;

import com.chayasadler.productservice.model.Product;
import com.chayasadler.productservice.model.ProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IProductRepository extends JpaRepository<Product, UUID> {

    @Query("SELECT new com.chayasadler.productservice.model.ProductResponse(p.name, p.description, p.price, " +
            " p.unit, p.productCategory, p.active) FROM Product p WHERE p.id=:productId")
    ProductResponse findProductById(UUID productId);
}
