package dev.rishit.vibecoder.service.impl;

import dev.rishit.vibecoder.dto.subscription.PlanResponse;
import dev.rishit.vibecoder.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
