package dev.rishit.vibecoder.service.impl.auth;

import dev.rishit.vibecoder.dto.auth.AuthResponse;
import dev.rishit.vibecoder.dto.auth.LoginRequest;
import dev.rishit.vibecoder.dto.auth.SignUpRequest;
import dev.rishit.vibecoder.dto.auth.UserDto;
import dev.rishit.vibecoder.entity.User;
import dev.rishit.vibecoder.exceptions.UnableToGenerateTokenException;
import dev.rishit.vibecoder.repository.UserRepository;
import dev.rishit.vibecoder.service.auth.AuthService;
import dev.rishit.vibecoder.service.auth.PostgresqlUserPrincipal;
import dev.rishit.vibecoder.service.mapper.UserMapper;
import dev.rishit.vibecoder.util.JwtUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class AuthServiceImpl implements AuthService {
    final AuthenticationManager authenticationManager;
    final UserRepository userRepository;
    final UserMapper userMapper;
    final PasswordEncoder passwordEncoder;

    final JwtUtil jwtUtil;

    public UserDto registerUser(SignUpRequest signUpRequest){
        String email = signUpRequest.getEmail();
        String password = passwordEncoder.encode(signUpRequest.getPassword());

        log.info(password);

        User user = new User();
        user.setEmail(email);
        user.setPasswordHash(password);

        User save = userRepository.save(user);

        log.info(save.toString());

        return userMapper.toUserDto(save);
    }

    public AuthResponse logInUser(LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        if(authentication.isAuthenticated()){
            Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
            if(user.isPresent()){
                String token = jwtUtil.generateToken(userMapper.toUserDto(user.get()).toString());
                log.info("User Token -> {}", token);
                return new AuthResponse(token, user.map(userMapper::toUserDto).orElse(null));
            }
        }

        throw new UnableToGenerateTokenException("Error Generating JWT_Token");
    }

    public UserDto userProfile(PostgresqlUserPrincipal principal){
        return userRepository.findByEmail(principal.getUsername())
                .map(userMapper::toUserDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
