create table  "authorization" (
        id                            bigserial
            constraint authorization_pk
                primary key,
                               "registeredClientId" varchar(255) NOT NULL,
                               "principalName" varchar(255) NOT NULL,
                               "authorizationGrantType" varchar(255) NOT NULL,
                               "attributes" varchar(4000) DEFAULT NULL,
                               "state_auth" varchar(500) DEFAULT NULL,
                               "authorizationCodeValue" varchar(4000) DEFAULT NULL,
                               "authorizationCodeIssuedAt" timestamp DEFAULT NULL,
                               "authorizationCodeExpiresAt" timestamp DEFAULT NULL,
                               "authorizationCodeMetadata" varchar(2000) DEFAULT NULL,
                               "accessTokenValue" varchar(4000) DEFAULT NULL,
                               "accessTokenIssuedAt" timestamp DEFAULT NULL,
                               "accessTokenExpiresAt" timestamp DEFAULT NULL,
                               "accessTokenMetadata" varchar(2000) DEFAULT NULL,
                               "accessTokenType" varchar(255) DEFAULT NULL,
                               "accessTokenScopes" varchar(1000) DEFAULT NULL,
                               "refreshTokenValue" varchar(4000) DEFAULT NULL,
                               "refreshTokenIssuedAt" timestamp DEFAULT NULL,
                               "refreshTokenExpiresAt" timestamp DEFAULT NULL,
                               "refreshTokenMetadata" varchar(2000) DEFAULT NULL,
                               "oidcIdTokenValue" varchar(4000) DEFAULT NULL,
                               "oidcIdTokenIssuedAt" timestamp DEFAULT NULL,
                               "oidcIdTokenExpiresAt" timestamp DEFAULT NULL,
                               "oidcIdTokenMetadata" varchar(2000) DEFAULT NULL,
                               "oidcIdTokenClaims" varchar(2000) DEFAULT NULL
);



create table "client"
(
    id                            bigserial
        constraint client_pk
            primary key,
    "clientId"                    varchar(255)                            not null,
    "clientIdIssuedAt"            timestamp     default current_timestamp not null,
    "clientSecret"                varchar(255)                            not null,
    "clientSecretExpiresAt"       timestamp     default null,
    "clientName"                  varchar(255)                            not null,
    "clientAuthenticationMethods" varchar(1000)                           not null,
    "authorizationGrantTypes"     varchar(1000)                           not null,
    "redirectUris"                varchar(1000) default NULL,
    scopes                        varchar(1000)                           not null,
    "clientSettings"              varchar(2000)                           not null,
    "tokenSettings"               varchar(2000)                           not null
);

create table "authorizationConsent" (
                                      "registeredClientId" varchar(255) NOT NULL,
                                      "principalName" varchar(255) NOT NULL,
                                      "authorities" varchar(1000) NOT NULL
);

