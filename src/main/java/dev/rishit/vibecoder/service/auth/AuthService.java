package dev.rishit.vibecoder.service.auth;


import dev.rishit.vibecoder.dto.LoginRequest;
import dev.rishit.vibecoder.dto.SignUpRequest;
import dev.rishit.vibecoder.dto.UserDto;
import dev.rishit.vibecoder.entity.User;
import dev.rishit.vibecoder.exceptions.UnableToGenerateTokenException;
import dev.rishit.vibecoder.repository.UserRepository;
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
public class AuthService {

    final AuthenticationManager authenticationManager;
    final UserRepository userRepository;
    final PasswordEncoder passwordEncoder;
    final UserMapper userMapper;
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

        return userMapper.apply(save);
    }

    public String logInUser(LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        if(authentication.isAuthenticated()){
            Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
            if(user.isPresent()){
                String token = jwtUtil.generateToken(userMapper.apply(user.get()).toString());
                log.info("User Token -> {}", token);
                return token;
            }
        }

        throw new UnableToGenerateTokenException("Error Generating JWT_Token");
    }

}
