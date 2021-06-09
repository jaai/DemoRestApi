package com.jazz.restapidemo.controller;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface StepCountController {
	ResponseEntity<Map<String, Object>> getAllStepCountData(Pageable pageable);


	ResponseEntity<Map<String, Object>> getUserStepCount(String user_email, String date);


}