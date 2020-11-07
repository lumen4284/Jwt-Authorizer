package com.codingmogul.auth.jwtauthorizer.service;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        throw new RuntimeException();
    }

    @Override
    public boolean supports(Class<?> aClass) {
        throw new RuntimeException();
    }
}
