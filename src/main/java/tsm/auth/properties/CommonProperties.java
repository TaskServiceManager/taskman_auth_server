package tsm.auth.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Data
@Configuration
@Primary
@ConfigurationProperties(prefix = "tsm", ignoreUnknownFields = false)
public class CommonProperties {

    private Broker broker;
    private AuthServer authServer;

    /**
     * Settings broker connection
     */
    @Data
    public static class Broker {

        private String uRL;

        private String vHost;

        private String login;

        private String password;
    }


    /**
     * Main setting this authorization server
     */
    @Data
    public static class AuthServer {
        private String serverAuthUrl;

        private String name;

        private String ipAddress;

        private Integer port;
    }


}
