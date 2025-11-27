package com.chayasadler.productservice.model;

public record ProductRequest(String name, String description, Double price, String unit,
                             String category) {
}
