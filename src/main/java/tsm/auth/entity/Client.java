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
@Table(name = "`client`")
public class Client {
    @Id
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
        return Objects.equals(id, client.id) && Objects.equals(clientId, client.clientId) && Objects.equals(clientIdIssuedAt, client.clientIdIssuedAt) && Objects.equals(clientSecret, client.clientSecret) && Objects.equals(clientSecretExpiresAt, client.clientSecretExpiresAt) && Objects.equals(clientName, client.clientName) && Objects.equals(clientAuthenticationMethods, client.clientAuthenticationMethods) && Objects.equals(authorizationGrantTypes, client.authorizationGrantTypes) && Objects.equals(redirectUris, client.redirectUris) && Objects.equals(scopes, client.scopes) && Objects.equals(clientSettings, client.clientSettings) && Objects.equals(tokenSettings, client.tokenSettings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, clientIdIssuedAt, clientSecret, clientSecretExpiresAt, clientName, clientAuthenticationMethods, authorizationGrantTypes, redirectUris, scopes, clientSettings, tokenSettings);
    }
}

