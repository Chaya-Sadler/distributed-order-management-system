package com.chayasadler.authservice.service;


import com.chayasadler.authservice.controller.IFeignCustomerClient;
import com.chayasadler.authservice.dao.IAuthRepository;
import com.chayasadler.authservice.model.Customer;
import com.chayasadler.authservice.model.AuthRequest;
import com.chayasadler.authservice.model.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    IFeignCustomerClient iFeignCustomerClient;

    IAuthRepository iAuthRepository;

    public AuthService(IAuthRepository iAuthRepository) {
        this.iAuthRepository = iAuthRepository;
    }

    public ResponseEntity<String> registerCustomer(AuthRequest authRequest) {

        Customer customer = new Customer(bCryptPasswordEncoder.encode(authRequest.password()),
                authRequest.email());
        customer.setRole("CUSTOMER");
        customer.setCreateAt(LocalDateTime.now());
        Customer customerSaved = iAuthRepository.save(customer);

        CustomerRequest customerRequest = new CustomerRequest(customerSaved.getId(), authRequest.name(),
                authRequest.email(), authRequest.address());

        // call customer service registration
        iFeignCustomerClient.registerNewCustomer(customerRequest);
        return new ResponseEntity<>(" Customer registered Successfully!", HttpStatus.CREATED);

    }

}
