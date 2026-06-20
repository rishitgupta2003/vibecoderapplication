package dev.rishit.vibecoder.dto.auth;

public record UserProfileResponse(
        Long id,
        String username,
        String name
) {
}
