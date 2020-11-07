package com.codingmogul.auth.jwtauthorizer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "codingmogul.auth")
public class JwtProperties {
    private String type;
    private String algorithm;
    private String issuer;
    private String sub;
    private String secret;
    private int expires_in;
}
