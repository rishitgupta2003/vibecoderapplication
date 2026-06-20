package dev.rishit.vibecoder.service.impl;

import dev.rishit.vibecoder.dto.subscription.PlanLimitsResponse;
import dev.rishit.vibecoder.dto.subscription.UsageTodayResponse;
import dev.rishit.vibecoder.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {

    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
