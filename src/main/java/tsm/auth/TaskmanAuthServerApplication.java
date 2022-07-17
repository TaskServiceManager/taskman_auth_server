package tsm.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import tsm.auth.properties.CommonProperties;

@SpringBootApplication
public class TaskmanAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskmanAuthServerApplication.class, args);
    }

}
