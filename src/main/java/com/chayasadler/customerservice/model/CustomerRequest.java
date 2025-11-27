package com.chayasadler.customerservice.model;

import java.util.UUID;

public record CustomerRequest(UUID id, String name, String email, String address) {
}
