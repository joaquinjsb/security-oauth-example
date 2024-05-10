package com.example.authserver.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Configuration
public class InitializationConfig {
    private final RegisteredClientRepository registeredClientRepository;

    public InitializationConfig(RegisteredClientRepository registeredClientRepository) {
        this.registeredClientRepository = registeredClientRepository;
    }

    @PostConstruct
    public void init() {
        List<RegisteredClient> registeredClients= new ArrayList<>();

        String todoClient = "todo-client";

        RegisteredClient client = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId(todoClient)
                .clientSecret("{noop}secret")
                .clientName("Todos")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .redirectUris(uris -> uris.add(
                        "http://gateway.traefik.me/login/oauth2/code/todo-client"
                ))
                .postLogoutRedirectUris(uris -> uris.add(
                        "http://gateway.traefik.me"
                ))
                .scope(OidcScopes.OPENID)
                .clientSettings(ClientSettings.builder().requireProofKey(false).requireAuthorizationConsent(true).build())
                .build();

        registeredClients.add(client);

        processClients(registeredClients);
    }

    private void processClients(List<RegisteredClient> registeredClients) {
        for (RegisteredClient registeredClient : registeredClients) {
            RegisteredClient repoClient = registeredClientRepository.findByClientId(registeredClient.getClientId());

            String id = UUID.randomUUID().toString();

            if (repoClient != null) {
                id = repoClient.getId();
            }

            registeredClientRepository.save(RegisteredClient.from(registeredClient).id(id).build());
        }
    }
}
