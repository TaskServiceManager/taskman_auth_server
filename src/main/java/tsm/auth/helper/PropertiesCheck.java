package tsm.auth.helper;

import io.micrometer.core.instrument.util.StringUtils;
import tsm.auth.exceptions.FieldPropertiesEmptyException;
import tsm.auth.properties.CommonProperties;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Predicate;

public class PropertiesCheck {

    public static String getServerAuthUrl(CommonProperties properties, Boolean secured) throws FieldPropertiesEmptyException {
        Predicate<CommonProperties> autPortUrlEmpty = x ->  (StringUtils.isBlank(x.getAuthServer().getIpAddress()) || StringUtils.isBlank(x.getAuthServer().getPort()));
        StringJoiner err = new StringJoiner("\n");
        StringJoiner url = new StringJoiner("");
        if(Objects.nonNull(properties.getAuthServer())) {
            if (autPortUrlEmpty.test(properties) && (StringUtils.isBlank(properties.getAuthServer().getServerAuthUrl()))) {
                err.add("AuthServer URL must be specified! Check your configuration.");
                err.add("Example: tsm.authserver.serverAuthUrl =  http://localhost:8080/");
                err.add("Or another way: tsm.authserver.ipAddress = 127.0.0.1");
                err.add("tsm.authserver.port =8080");
            } else {
                if(Objects.nonNull(properties.getAuthServer().getServerAuthUrl())) {
                    url.add(properties.getAuthServer().getServerAuthUrl());
                } else {
                    if(secured) {
                        url.add("http://");
                    } else {
                        url.add("https://");
                    }
                    url.add(properties.getAuthServer().getIpAddress());
                    url.add(properties.getAuthServer().getPort());
                }
            }
        }
        if(err.length()>0) {
            throw new FieldPropertiesEmptyException(err.toString());
        }

        return url.toString();
    }


}
