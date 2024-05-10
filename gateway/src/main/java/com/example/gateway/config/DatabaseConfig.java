package com.example.gateway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.security.oauth2.client.R2dbcReactiveOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;

@Configuration
public class DatabaseConfig {

    @Bean
    ReactiveOAuth2AuthorizedClientService authorizedClientService(DatabaseClient dbClient, ReactiveClientRegistrationRepository clientRegistrationRepository) {
        return new R2dbcReactiveOAuth2AuthorizedClientService(dbClient, clientRegistrationRepository);
    }
}
