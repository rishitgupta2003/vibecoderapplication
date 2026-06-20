package dev.rishit.vibecoder.service;

import dev.rishit.vibecoder.dto.subscription.PlanLimitsResponse;
import dev.rishit.vibecoder.dto.subscription.UsageTodayResponse;

public interface UsageService {
     UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
