package com.chayasadler.authservice.controller;

import com.chayasadler.authservice.model.CustomerRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("CUSTOMERSERVICE")
public interface IFeignCustomerClient {

    @PostMapping("/customer/register")
    public ResponseEntity<String> registerNewCustomer(@RequestBody CustomerRequest customer);
}
