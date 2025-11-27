package com.chayasadler.customerservice.controller;

import com.chayasadler.customerservice.model.CustomerRequest;
import com.chayasadler.customerservice.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerNewCustomer(@RequestBody CustomerRequest customer){

        return customerService.registerNewCustomer(customer);

    }

}
