package com.chayasadler.authservice.service;

import com.chayasadler.authservice.dao.IAuthRepository;
import com.chayasadler.authservice.model.AuthResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomerDetailsService implements UserDetailsService {

    private final IAuthRepository iAuthRepository;

    public CustomerDetailsService(IAuthRepository iAuthRepository) {
        this.iAuthRepository = iAuthRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthResponse authResponse = iAuthRepository.findByEmail(username);
        return new AuthCustomerDetails(authResponse);
    }
}
