package dev.rishit.vibecoder.dto.project;

import dev.rishit.vibecoder.dto.auth.UserDto;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        UserDto owner
) {}