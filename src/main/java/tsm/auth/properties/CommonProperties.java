package tsm.auth.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@Data
@ConfigurationProperties(prefix = "tsm", ignoreUnknownFields = false)
public class CommonProperties {

    private Broker broker;
    private AuthServer authServer;

    /**
     * Settings broker connection
     */
    @Data
    public static class Broker {

        private String URL;

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
