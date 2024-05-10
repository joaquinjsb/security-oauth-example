package com.example.authserver.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "client", uniqueConstraints = {
        @UniqueConstraint(name = "uc_client_clientid", columnNames = {"clientId"})
})
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String clientId;
    private Instant clientIdIssuedAt;
    private String clientSecret;
    private Instant clientSecretExpiresAt;
    private String clientName;
    @Column(length = 1000)
    private String clientAuthenticationMethods;
    @Column(length = 1000)
    private String authorizationGrantTypes;
    @Column(length = 1000)
    private String redirectUris;
    @Column(length = 1000)
    private String postLogoutRedirectUris;
    @Column(length = 1000)
    private String scopes;
    @Column(length = 2000)
    private String clientSettings;
    @Column(length = 2000)
    private String tokenSettings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;
        return Objects.equals(getId(), client.getId()) && Objects.equals(getClientId(), client.getClientId()) && Objects.equals(getClientIdIssuedAt(), client.getClientIdIssuedAt()) && Objects.equals(getClientSecret(), client.getClientSecret()) && Objects.equals(getClientSecretExpiresAt(), client.getClientSecretExpiresAt()) && Objects.equals(getClientName(), client.getClientName()) && Objects.equals(getClientAuthenticationMethods(), client.getClientAuthenticationMethods()) && Objects.equals(getAuthorizationGrantTypes(), client.getAuthorizationGrantTypes()) && Objects.equals(getRedirectUris(), client.getRedirectUris()) && Objects.equals(getPostLogoutRedirectUris(), client.getPostLogoutRedirectUris()) && Objects.equals(getScopes(), client.getScopes()) && Objects.equals(getClientSettings(), client.getClientSettings()) && Objects.equals(getTokenSettings(), client.getTokenSettings());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getClientId());
        result = 31 * result + Objects.hashCode(getClientIdIssuedAt());
        result = 31 * result + Objects.hashCode(getClientSecret());
        result = 31 * result + Objects.hashCode(getClientSecretExpiresAt());
        result = 31 * result + Objects.hashCode(getClientName());
        result = 31 * result + Objects.hashCode(getClientAuthenticationMethods());
        result = 31 * result + Objects.hashCode(getAuthorizationGrantTypes());
        result = 31 * result + Objects.hashCode(getRedirectUris());
        result = 31 * result + Objects.hashCode(getPostLogoutRedirectUris());
        result = 31 * result + Objects.hashCode(getScopes());
        result = 31 * result + Objects.hashCode(getClientSettings());
        result = 31 * result + Objects.hashCode(getTokenSettings());
        return result;
    }
}
