package com.chayasadler.customerservice.service;

import com.chayasadler.customerservice.dao.ICustomerRepository;
import com.chayasadler.customerservice.model.Customer;
import com.chayasadler.customerservice.model.CustomerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerService {

    ICustomerRepository iCustomerRepository;

    public CustomerService(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    public ResponseEntity<String> registerNewCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer(customerRequest.id(), customerRequest.name(), customerRequest.address(),
                customerRequest.email());
        customer.setCreatedAt(LocalDateTime.now());
        iCustomerRepository.save(customer);

        return new ResponseEntity<> ("Success",HttpStatus.CREATED);
    }
}
