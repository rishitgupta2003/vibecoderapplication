package dev.rishit.vibecoder.service;

import dev.rishit.vibecoder.dto.subscription.CheckoutRequest;
import dev.rishit.vibecoder.dto.subscription.CheckoutResponse;
import dev.rishit.vibecoder.dto.subscription.PortalResponse;
import dev.rishit.vibecoder.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);

    PortalResponse openCustomerPortal(Long userId);
}
