package com.subscription.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.subscription.entities.Company;
import com.subscription.models.CompanyBean;
import com.subscription.models.CompanyPrivateDetails;
import com.subscription.repositories.CompanyRepository;
import com.subscription.utils.EncryptionUtil;

@Service
public class SubscriptionService {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private CompanyRepository companyRepository;

	public Long createSubscription(CompanyBean companyBean) throws Exception {
		CompanyPrivateDetails companyPrivateDetails = companyBean.getCompanyPrivateDetails();

		String data = objectMapper.writeValueAsString(companyPrivateDetails);
		String subscriptionKey = EncryptionUtil.encrypt(data);
		Company company = new Company();
		company.setName(companyBean.getName());
		company.setExpiryDate(companyBean.getExpiryDate());
		company.setSubscriptionLevel(companyBean.getSubscriptionLevel());
		company.setSubscriptionKey(subscriptionKey);

		company = companyRepository.save(company);
		return company.getId();
	}

	public CompanyBean decodeSubscriptionKey(Long companyId) throws Exception {
		Optional<Company> companyOpt = companyRepository.findById(companyId);
		if (companyOpt.isPresent()) {
			Company company = companyOpt.get();
			CompanyBean companyBean = new CompanyBean();
			companyBean.setName(company.getName());
			companyBean.setExpiryDate(company.getExpiryDate());
			companyBean.setSubscriptionLevel(company.getSubscriptionLevel());
			String decryptedData = EncryptionUtil.decrypt(company.getSubscriptionKey());
			companyBean.setCompanyPrivateDetails(objectMapper.readValue(decryptedData, CompanyPrivateDetails.class));
			return companyBean;
		} else {
			throw new IllegalArgumentException("Invalid subscription key/company id");
		}
	}

	public CompanyBean getSubscription(Long companyId) throws Exception {
		Optional<Company> companyOpt = companyRepository.findById(companyId);
		if (companyOpt.isPresent()) {
			Company company = companyOpt.get();
			CompanyBean companyBean = new CompanyBean();
			companyBean.setName(company.getName());
			companyBean.setExpiryDate(company.getExpiryDate());
			companyBean.setSubscriptionLevel(company.getSubscriptionLevel());
			return companyBean;
		} else {
			throw new IllegalArgumentException("Invalid company id");
		}
	}
}
