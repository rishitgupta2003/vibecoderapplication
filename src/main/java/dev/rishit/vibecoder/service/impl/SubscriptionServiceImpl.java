package dev.rishit.vibecoder.service.impl;

import dev.rishit.vibecoder.dto.subscription.CheckoutRequest;
import dev.rishit.vibecoder.dto.subscription.CheckoutResponse;
import dev.rishit.vibecoder.dto.subscription.PortalResponse;
import dev.rishit.vibecoder.dto.subscription.SubscriptionResponse;
import dev.rishit.vibecoder.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
