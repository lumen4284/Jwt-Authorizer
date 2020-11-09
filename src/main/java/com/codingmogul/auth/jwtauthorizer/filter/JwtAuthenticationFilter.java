package com.codingmogul.auth.jwtauthorizer.filter;

import com.codingmogul.auth.jwtauthorizer.model.CustomAuthenticationToken;
import com.codingmogul.auth.jwtauthorizer.model.DefaultAuthRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            DefaultAuthRequest defaultAuthRequest = new ObjectMapper().readValue(request.getInputStream(), DefaultAuthRequest.class);
            return authenticationManager
                    .authenticate(new CustomAuthenticationToken(defaultAuthRequest.getUserId(), defaultAuthRequest.getPassword(), defaultAuthRequest.getExtra(), new ArrayList<>()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("authResult = " + authResult);
        super.successfulAuthentication(request, response, chain, authResult);
    }
}
