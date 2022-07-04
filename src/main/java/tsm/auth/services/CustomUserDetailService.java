package tsm.auth.services;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tsm.auth.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).map(
                user -> new User(
                        user.getEmail(),
                        user.getPassword(),
                        user.getEnabled(),
                        true,
                        true,
                        true,
                        List.of(user.getRole()).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
                )).orElseThrow(() -> new UsernameNotFoundException(email));
    }

    // Access Granted list of roles
//    private Collection<? extends GrantedAuthority> getAuthorities(List<String> roles) {
//        List<GrantedAuthority>  authorities = new ArrayList<>();
//        for(String role: roles) {
//            authorities.add(new SimpleGrantedAuthority(role));
//        }
//        return authorities;
//    }
}
