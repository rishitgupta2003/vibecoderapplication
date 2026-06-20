package dev.rishit.vibecoder.dto.member;

import dev.rishit.vibecoder.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectRole role) {
}
