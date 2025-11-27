package com.chayasadler.authservice.dao;

import com.chayasadler.authservice.model.AuthResponse;
import com.chayasadler.authservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IAuthRepository extends JpaRepository<Customer, UUID> {

    AuthResponse findByEmail(String username);
}
