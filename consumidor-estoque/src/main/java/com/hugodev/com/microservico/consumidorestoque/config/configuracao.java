package com.hugodev.com.microservico.consumidorestoque.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configuracao {

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
