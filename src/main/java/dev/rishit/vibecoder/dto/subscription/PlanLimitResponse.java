package dev.rishit.vibecoder.dto.subscription;

public record PlanLimitResponse(
        String planName,
        int maxTokensPerDay,
        int maxProject,
        boolean unlimitedAi
) {
}
