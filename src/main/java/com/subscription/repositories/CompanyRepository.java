package com.subscription.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.subscription.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	Company findBySubscriptionKey(String subscriptionKey);
}