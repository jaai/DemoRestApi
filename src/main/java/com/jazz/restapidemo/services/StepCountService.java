package com.jazz.restapidemo.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jazz.restapidemo.model.data.StepCountData;
public interface StepCountService {
	Page<StepCountData> getAllStepCountData(Pageable pageable);

	StepCountData getUserStepCount(String user_email, String date);

	
}
