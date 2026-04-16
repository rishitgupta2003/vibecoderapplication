package dev.rishit.vibecoder.service.auth;

import dev.rishit.vibecoder.dto.auth.AuthResponse;
import dev.rishit.vibecoder.dto.auth.LoginRequest;
import dev.rishit.vibecoder.dto.auth.SignUpRequest;
import dev.rishit.vibecoder.dto.auth.UserDto;
import org.springframework.stereotype.Service;


@Service
public interface AuthService {
    public UserDto registerUser(SignUpRequest signUpRequest);
    public AuthResponse logInUser(LoginRequest loginRequest);
    public UserDto userProfile(PostgresqlUserPrincipal principal);
}