package tsm.auth.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`authorization`")
public class Authorization {
    @Id
    @Column
    private String id;
    private String registeredClientId;
    private String principalName;
    private String authorizationGrantType;
    @Column(length = 4000)
    private String attributes;
    @Column(length = 500, name = "state_auth")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authorization that = (Authorization) o;
        return id.equals(that.id) && Objects.equals(registeredClientId, that.registeredClientId) && Objects.equals(principalName, that.principalName) && Objects.equals(authorizationGrantType, that.authorizationGrantType) && Objects.equals(attributes, that.attributes) && Objects.equals(state, that.state) && Objects.equals(authorizationCodeValue, that.authorizationCodeValue) && Objects.equals(authorizationCodeIssuedAt, that.authorizationCodeIssuedAt) && Objects.equals(authorizationCodeExpiresAt, that.authorizationCodeExpiresAt) && Objects.equals(authorizationCodeMetadata, that.authorizationCodeMetadata) && Objects.equals(accessTokenValue, that.accessTokenValue) && Objects.equals(accessTokenIssuedAt, that.accessTokenIssuedAt) && Objects.equals(accessTokenExpiresAt, that.accessTokenExpiresAt) && Objects.equals(accessTokenMetadata, that.accessTokenMetadata) && Objects.equals(accessTokenType, that.accessTokenType) && Objects.equals(accessTokenScopes, that.accessTokenScopes) && Objects.equals(refreshTokenValue, that.refreshTokenValue) && Objects.equals(refreshTokenIssuedAt, that.refreshTokenIssuedAt) && Objects.equals(refreshTokenExpiresAt, that.refreshTokenExpiresAt) && Objects.equals(refreshTokenMetadata, that.refreshTokenMetadata) && Objects.equals(oidcIdTokenValue, that.oidcIdTokenValue) && Objects.equals(oidcIdTokenIssuedAt, that.oidcIdTokenIssuedAt) && Objects.equals(oidcIdTokenExpiresAt, that.oidcIdTokenExpiresAt) && Objects.equals(oidcIdTokenMetadata, that.oidcIdTokenMetadata) && Objects.equals(oidcIdTokenClaims, that.oidcIdTokenClaims);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registeredClientId, principalName, authorizationGrantType, attributes, state, authorizationCodeValue, authorizationCodeIssuedAt, authorizationCodeExpiresAt, authorizationCodeMetadata, accessTokenValue, accessTokenIssuedAt, accessTokenExpiresAt, accessTokenMetadata, accessTokenType, accessTokenScopes, refreshTokenValue, refreshTokenIssuedAt, refreshTokenExpiresAt, refreshTokenMetadata, oidcIdTokenValue, oidcIdTokenIssuedAt, oidcIdTokenExpiresAt, oidcIdTokenMetadata, oidcIdTokenClaims);
    }
}

