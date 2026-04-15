package dev.rishit.vibecoder.dto.subscription;

public record UsageTodayResponse(
        int tokenUsed,
        int tokensLimit,
        int previewsRunning,
        int previewsLimit
) {
}
