package dev.rishit.vibecoder.dto.member;

import dev.rishit.vibecoder.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String username,
        String name,
        ProjectRole projectRole,
        Instant invitedAt
) {
}
