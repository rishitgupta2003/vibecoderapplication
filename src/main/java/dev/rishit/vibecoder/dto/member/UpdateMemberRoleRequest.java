package dev.rishit.vibecoder.dto.member;

import dev.rishit.vibecoder.enums.ProjectRole;

public record UpdateMemberRoleRequest(
        ProjectRole role
) {
}
