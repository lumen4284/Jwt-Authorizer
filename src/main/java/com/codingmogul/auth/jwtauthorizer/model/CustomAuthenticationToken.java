package com.codingmogul.auth.jwtauthorizer.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private Object extra;

    public CustomAuthenticationToken(Object principal, Object credentials, Object extra,  Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        this.extra = extra;
    }

    public Object getExtra() {
        return extra;
    }
}
