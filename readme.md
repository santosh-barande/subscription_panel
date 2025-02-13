
## AppName: Subscription Panel

#### API 1: Create company subscription with encoding sensitive information

###### API EndPoint: /api/admin/subscription/generate

###### Method: POST

###### Sample JSON Request:


	{
	    "name": "Bajaj Fins",
	    "subscriptionLevel": "Gold",
	    "expiryDate": "2025-10-11",
	    "companyPrivateDetails": {
	        "tanNumber": "BQZPQ2229Z",
	        "registrationNumber": "COM_BJFIS_001"
	    }
	}

###### Sample JSON Response: company id will be returned, in long format


#### API 2: Get company subscription details with decoded information

###### EndPoint: /api/admin/subscription/decode?companyId=1

###### Method: GET

###### Request Param: companyId -> long company id

###### Sample JSON Response:


	{
	    "id":1,
	    "name": "Bajaj Fins",
	    "subscriptionLevel": "Gold",
	    "expiryDate": "2025-10-11",
	    "companyPrivateDetails": {
	        "tanNumber": "BQZPQ2229Z",
	        "registrationNumber": "COM_BJFIS_001"
	    }
	}


#### API 3: Get company subscription details without sensitive info

###### API EndPoint: /api/subscription/company?companyId=1

###### Method: GET

###### Request Param: companyId -> long company id

###### Sample JSON Response:

	{
	    "id":1,
	    "name": "Bajaj Fins",
	    "subscriptionLevel": "Gold",
	    "expiryDate": "2025-10-11"
	}
