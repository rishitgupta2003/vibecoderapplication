package dev.rishit.vibecoder.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    String email;
    String password;
}
