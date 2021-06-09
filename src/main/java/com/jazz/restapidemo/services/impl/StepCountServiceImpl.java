package com.jazz.restapidemo.services.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jazz.restapidemo.model.data.StepCountData;
import com.jazz.restapidemo.repository.StepCountRepo;
import com.jazz.restapidemo.services.StepCountService;
import com.jazz.restapidemo.utils.CommanUtils;
@Service
public class StepCountServiceImpl implements StepCountService {
	@Autowired
	private StepCountRepo stepCountRepo;

	@Override
	public Page<StepCountData> getAllStepCountData(Pageable pageable) {
		Long allStepCountsRecord = stepCountRepo.getAllStepCountDataCount();
		List<StepCountData> stepCountDataList = stepCountRepo.findAllData(pageable);
		Page<StepCountData> StepCountDetailPage = new PageImpl<StepCountData>(stepCountDataList, pageable,
				allStepCountsRecord);
		return StepCountDetailPage;
	}

	@Override
	public StepCountData getUserStepCount(String user_email, String date) {
		CommanUtils cu = new CommanUtils();

		StepCountData stepCountData = stepCountRepo.findStepCountByEmail(user_email, cu.convertToDateFromURL(date));
		return stepCountData;
	}

}