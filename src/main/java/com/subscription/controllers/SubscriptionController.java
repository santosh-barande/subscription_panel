 package com.subscription.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.subscription.models.CompanyBean;
import com.subscription.services.SubscriptionService;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

	@Autowired
	private SubscriptionService subscriptionService;

	@GetMapping("/company")
	public CompanyBean decodeKey(@RequestParam Long companyId) throws Exception {
		return subscriptionService.getSubscription(companyId);
	}
}
