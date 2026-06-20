package dev.rishit.vibecoder.service;

import dev.rishit.vibecoder.dto.auth.UserProfileResponse;

public interface UserService {
    UserProfileResponse getProfile(Long userId);
}
