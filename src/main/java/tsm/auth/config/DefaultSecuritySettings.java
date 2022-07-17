package tsm.auth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import tsm.auth.providers.CustomAuthenticationProvider;

@EnableWebSecurity
@RequiredArgsConstructor
public class DefaultSecuritySettings {

    private CustomAuthenticationProvider customAuthenticationProvider;


    @Bean
    SecurityFilterChain configureSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

    public void bindAuthenticationProvider(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder
                .authenticationProvider(customAuthenticationProvider);
    }



}
