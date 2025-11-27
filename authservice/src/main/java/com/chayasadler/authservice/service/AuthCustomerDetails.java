package com.chayasadler.authservice.service;

import com.chayasadler.authservice.model.AuthResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AuthCustomerDetails implements UserDetails {

    AuthResponse authResponse;

    public AuthCustomerDetails(AuthResponse authResponse) {
        this.authResponse = authResponse;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("CUSTOMER"));
    }

    @Override
    public String getPassword() {
        System.out.println("password");
        return authResponse.password();
    }

    @Override
    public String getUsername() {
        return authResponse.email();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
