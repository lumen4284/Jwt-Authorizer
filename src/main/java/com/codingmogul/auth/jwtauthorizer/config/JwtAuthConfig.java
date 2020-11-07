package com.codingmogul.auth.jwtauthorizer.config;

import com.codingmogul.auth.jwtauthorizer.service.CustomAuthenticationProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(JwtProperties.class)
public class JwtAuthConfig {
    private final JwtProperties jwtProperties;

    public JwtAuthConfig(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }


    @Bean
    @ConditionalOnMissingBean
    public CustomAuthenticationProvider customAuthenticationProvider(){
        return new CustomAuthenticationProvider();
    }
}
