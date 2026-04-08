package dev.rishit.vibecoder.controller;


import dev.rishit.vibecoder.dto.auth.AuthResponse;
import dev.rishit.vibecoder.dto.auth.LoginRequest;
import dev.rishit.vibecoder.dto.auth.SignUpRequest;
import dev.rishit.vibecoder.dto.auth.UserDto;
import dev.rishit.vibecoder.repository.UserRepository;
import dev.rishit.vibecoder.service.auth.AuthService;
import dev.rishit.vibecoder.service.auth.PostgresqlUserPrincipal;
import dev.rishit.vibecoder.service.mapper.UserMapper;
import dev.rishit.vibecoder.util.ResponseBuilder;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthController {

    final AuthService authService;
    final ResponseBuilder responseBuilder;
    final UserRepository userRepository;
    final UserMapper userMapper;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signUp(@Valid @RequestBody SignUpRequest signUpRequest){
        UserDto userDto = authService.registerUser(signUpRequest);
        return responseBuilder.buildCreatedResponse(Map.of("message", "User created successfully", "user", userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@Valid @RequestBody LoginRequest loginRequest){
        AuthResponse userToken = authService.logInUser(loginRequest);
        return responseBuilder.buildOkResponse(userToken);
    }
    
    @GetMapping("/profile")
    public ResponseEntity<Map<String, Object>> profile(@AuthenticationPrincipal PostgresqlUserPrincipal principal) {
        UserDto userDto = authService.userProfile(principal);
        return responseBuilder.buildOkResponse(userDto);
    }
}
