package com.chayasadler.authservice.model;

import java.util.UUID;

public record CustomerRequest(UUID id, String name, String email, String address) {
}
