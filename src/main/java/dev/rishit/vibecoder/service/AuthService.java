package dev.rishit.vibecoder.service;

import dev.rishit.vibecoder.dto.auth.AuthResponse;
import dev.rishit.vibecoder.dto.auth.LoginRequest;
import dev.rishit.vibecoder.dto.auth.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
