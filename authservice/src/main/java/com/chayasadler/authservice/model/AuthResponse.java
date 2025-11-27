package com.chayasadler.authservice.model;

public record AuthResponse(String email, String role, String password) {
}
