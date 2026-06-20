package dev.rishit.vibecoder.service;

import dev.rishit.vibecoder.dto.subscription.PlanResponse;

import java.util.List;

public interface PlanService {
     List<PlanResponse> getAllActivePlans();
}
