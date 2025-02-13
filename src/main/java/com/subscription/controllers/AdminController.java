package com.subscription.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.subscription.models.CompanyBean;
import com.subscription.services.SubscriptionService;

@RestController
@RequestMapping("/api/admin/subscription")
public class AdminController {

	@Autowired
	private SubscriptionService subscriptionService;

	@PostMapping("/generate")
	public Long generateKey(@RequestBody CompanyBean company) throws Exception {
		return subscriptionService.createSubscription(company);
	}

	@GetMapping("/decode")
	public CompanyBean decodeKey(@RequestParam Long companyId) throws Exception {
		return subscriptionService.decodeSubscriptionKey(companyId);
	}

}
