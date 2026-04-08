package dev.rishit.vibecoder.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class AuthResponse {
    String token;
    UserDto userProfile;
}


