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
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "`authorization`")
public class Authorization implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String registeredClientId;
    private String principalName;
    private String authorizationGrantType;
    @Column(length = 1000)
    private String authorizedScopes;
    @Column(length = 4000)
    private String attributes;
    @Column(length = 500)
    private String state;

    @Column(length = 4000)
    private String authorizationCodeValue;
    private Instant authorizationCodeIssuedAt;
    private Instant authorizationCodeExpiresAt;
    private String authorizationCodeMetadata;

    @Column(length = 4000)
    private String accessTokenValue;
    private Instant accessTokenIssuedAt;
    private Instant accessTokenExpiresAt;
    @Column(length = 2000)
    private String accessTokenMetadata;
    private String accessTokenType;
    @Column(length = 1000)
    private String accessTokenScopes;

    @Column(length = 4000)
    private String refreshTokenValue;
    private Instant refreshTokenIssuedAt;
    private Instant refreshTokenExpiresAt;
    @Column(length = 2000)
    private String refreshTokenMetadata;

    @Column(length = 4000)
    private String oidcIdTokenValue;
    private Instant oidcIdTokenIssuedAt;
    private Instant oidcIdTokenExpiresAt;
    @Column(length = 2000)
    private String oidcIdTokenMetadata;
    @Column(length = 2000)
    private String oidcIdTokenClaims;

    @Column(length = 4000)
    private String userCodeValue;
    private Instant userCodeIssuedAt;
    private Instant userCodeExpiresAt;
    @Column(length = 2000)
    private String userCodeMetadata;

    @Column(length = 4000)
    private String deviceCodeValue;
    private Instant deviceCodeIssuedAt;
    private Instant deviceCodeExpiresAt;
    @Column(length = 2000)
    private String deviceCodeMetadata;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authorization that = (Authorization) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getRegisteredClientId(), that.getRegisteredClientId()) && Objects.equals(getPrincipalName(), that.getPrincipalName()) && Objects.equals(getAuthorizationGrantType(), that.getAuthorizationGrantType()) && Objects.equals(getAuthorizedScopes(), that.getAuthorizedScopes()) && Objects.equals(getAttributes(), that.getAttributes()) && Objects.equals(getState(), that.getState()) && Objects.equals(getAuthorizationCodeValue(), that.getAuthorizationCodeValue()) && Objects.equals(getAuthorizationCodeIssuedAt(), that.getAuthorizationCodeIssuedAt()) && Objects.equals(getAuthorizationCodeExpiresAt(), that.getAuthorizationCodeExpiresAt()) && Objects.equals(getAuthorizationCodeMetadata(), that.getAuthorizationCodeMetadata()) && Objects.equals(getAccessTokenValue(), that.getAccessTokenValue()) && Objects.equals(getAccessTokenIssuedAt(), that.getAccessTokenIssuedAt()) && Objects.equals(getAccessTokenExpiresAt(), that.getAccessTokenExpiresAt()) && Objects.equals(getAccessTokenMetadata(), that.getAccessTokenMetadata()) && Objects.equals(getAccessTokenType(), that.getAccessTokenType()) && Objects.equals(getAccessTokenScopes(), that.getAccessTokenScopes()) && Objects.equals(getRefreshTokenValue(), that.getRefreshTokenValue()) && Objects.equals(getRefreshTokenIssuedAt(), that.getRefreshTokenIssuedAt()) && Objects.equals(getRefreshTokenExpiresAt(), that.getRefreshTokenExpiresAt()) && Objects.equals(getRefreshTokenMetadata(), that.getRefreshTokenMetadata()) && Objects.equals(getOidcIdTokenValue(), that.getOidcIdTokenValue()) && Objects.equals(getOidcIdTokenIssuedAt(), that.getOidcIdTokenIssuedAt()) && Objects.equals(getOidcIdTokenExpiresAt(), that.getOidcIdTokenExpiresAt()) && Objects.equals(getOidcIdTokenMetadata(), that.getOidcIdTokenMetadata()) && Objects.equals(getOidcIdTokenClaims(), that.getOidcIdTokenClaims()) && Objects.equals(getUserCodeValue(), that.getUserCodeValue()) && Objects.equals(getUserCodeIssuedAt(), that.getUserCodeIssuedAt()) && Objects.equals(getUserCodeExpiresAt(), that.getUserCodeExpiresAt()) && Objects.equals(getUserCodeMetadata(), that.getUserCodeMetadata()) && Objects.equals(getDeviceCodeValue(), that.getDeviceCodeValue()) && Objects.equals(getDeviceCodeIssuedAt(), that.getDeviceCodeIssuedAt()) && Objects.equals(getDeviceCodeExpiresAt(), that.getDeviceCodeExpiresAt()) && Objects.equals(getDeviceCodeMetadata(), that.getDeviceCodeMetadata());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRegisteredClientId(), getPrincipalName(), getAuthorizationGrantType(), getAuthorizedScopes(), getAttributes(), getState(), getAuthorizationCodeValue(), getAuthorizationCodeIssuedAt(), getAuthorizationCodeExpiresAt(), getAuthorizationCodeMetadata(), getAccessTokenValue(), getAccessTokenIssuedAt(), getAccessTokenExpiresAt(), getAccessTokenMetadata(), getAccessTokenType(), getAccessTokenScopes(), getRefreshTokenValue(), getRefreshTokenIssuedAt(), getRefreshTokenExpiresAt(), getRefreshTokenMetadata(), getOidcIdTokenValue(), getOidcIdTokenIssuedAt(), getOidcIdTokenExpiresAt(), getOidcIdTokenMetadata(), getOidcIdTokenClaims(), getUserCodeValue(), getUserCodeIssuedAt(), getUserCodeExpiresAt(), getUserCodeMetadata(), getDeviceCodeValue(), getDeviceCodeIssuedAt(), getDeviceCodeExpiresAt(), getDeviceCodeMetadata());
    }
}
