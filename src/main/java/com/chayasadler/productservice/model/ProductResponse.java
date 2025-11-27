package com.chayasadler.productservice.model;

public record ProductResponse(String name, String description, Double price, String unit,
                              String category, Boolean active) {
}
