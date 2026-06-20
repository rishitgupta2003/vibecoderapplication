package dev.rishit.vibecoder.dto.auth;

public record AuthResponse(
        String token,
        UserProfileResponse user
) {

}
