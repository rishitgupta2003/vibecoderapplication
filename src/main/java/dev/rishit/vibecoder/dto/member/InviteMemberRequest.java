package dev.rishit.vibecoder.dto.member;

import dev.rishit.vibecoder.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
){}
