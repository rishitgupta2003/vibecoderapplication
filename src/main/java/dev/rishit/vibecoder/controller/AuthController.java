package dev.rishit.vibecoder.controller;


import dev.rishit.vibecoder.dto.LoginRequest;
import dev.rishit.vibecoder.dto.SignUpRequest;
import dev.rishit.vibecoder.service.AuthService;
import dev.rishit.vibecoder.service.UserService;
import dev.rishit.vibecoder.util.ResponseBuilder;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthController {

    final AuthService authService;
    final UserService userService;
    final ResponseBuilder responseBuilder;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signUp(SignUpRequest signUpRequest){
        //TODO->Complete Logic

        return responseBuilder.buildCreatedResponse("User SignUp Successfull");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(LoginRequest loginRequest){
        //TODO->Complete Logic

        return responseBuilder.buildCreatedResponse("User Login Successfull");
    }

    @GetMapping("/profile")
    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> profile(){
        //TODO->Complete Logic

        return responseBuilder.buildCreatedResponse("User SignUp Successfull");
    }
}
