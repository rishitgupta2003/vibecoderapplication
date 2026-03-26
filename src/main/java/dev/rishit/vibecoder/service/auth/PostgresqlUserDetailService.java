package dev.rishit.vibecoder.service.auth;

import dev.rishit.vibecoder.entity.User;
import dev.rishit.vibecoder.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostgresqlUserDetailService implements UserDetailsService {

    final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userResult = userRepository.findByEmail(email);

        if(userResult.isEmpty()){
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        User user = userResult.get();

        return new PostgresqlUserPrincipal(){

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of();
            }

            @Override
            public @Nullable String getPassword() {
                return user.getPasswordHash();
            }

            @Override
            public String getUsername() {
                return user.getEmail();
            }
        };
    }
}
