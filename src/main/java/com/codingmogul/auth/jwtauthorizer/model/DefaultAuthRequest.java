package com.codingmogul.auth.jwtauthorizer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DefaultAuthRequest {
    private String userId;
    private String password;
    private Object extra;
}
