package com.jazz.restapidemo.controller.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jazz.restapidemo.controller.StepCountController;
import com.jazz.restapidemo.model.data.StepCountData;
import com.jazz.restapidemo.model.data.Users;
import com.jazz.restapidemo.model.response.StepCountsByUserEmailResponseModel;
import com.jazz.restapidemo.repository.StepCountRepo;
import com.jazz.restapidemo.services.StepCountService;
import com.jazz.restapidemo.services.UserDetailService;
import com.jazz.restapidemo.utils.CommanUtils;



@RestController
@RequestMapping("v1/stepcount/stepcounts")
public class StepCountControllerImpl implements StepCountController {

	@Autowired
	StepCountService stepCountService;
	@Autowired
	StepCountRepo stepCountRepo;
	@Autowired
	UserDetailService userDetailService;
CommanUtils cu=new CommanUtils();
	@Override
	@GetMapping(value = "/allData")
	public ResponseEntity<Map<String, Object>> getAllStepCountData(Pageable pageable) {
		Page<StepCountData> StepCountDataList = stepCountService.getAllStepCountData(pageable);

		if (StepCountDataList.getContent().size() > 0) {

			Map<String, Object> response = new HashMap<>();
			response.put("statusMessage", "Success");
			response.put("statusCode", 200);
			response.put("data", StepCountDataList);

			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {

			Map<String, Object> response = new HashMap<>();
			response.put("statusMessage", "Fail");
			response.put("statusCode", 404);
			response.put("data", null);

			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(value = "/save")
	public ResponseEntity<Map<String, Object>> saveUser(@RequestBody StepCountData StepCountData) {
		
		List<StepCountData> stepCountData1=stepCountRepo.findStepCountByDate(cu.convertToDate(StepCountData.getDate().toString()),StepCountData.getUserEmail());
		if(stepCountData1!=null) {
			stepCountRepo.deleteInBatch(stepCountData1);
		}
		StepCountData stepCountData = stepCountRepo.save(StepCountData);
		
		if (stepCountData != null) {
			Map<String, Object> response = new HashMap<>();
			response.put("statusMessage", "Data saved successfully");
			response.put("statusCode", 200);

			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			Map<String, Object> response = new HashMap<>();
			response.put("statusMessage", "Fail");
			response.put("statusCode", 404);

			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}

	@Override
	@GetMapping(value = "/{user_email}/{date}")
	public ResponseEntity<Map<String, Object>> getUserStepCount(@PathVariable("user_email") String user_email,
			@PathVariable("date") String date) {
		StepCountData stepCountData = stepCountService.getUserStepCount(user_email,date);
		Users user = userDetailService.getUserbyEmail(user_email);
		StepCountsByUserEmailResponseModel res = new StepCountsByUserEmailResponseModel();
		res.setGoal("10000");
		res.setPrevCount(stepCountData);
		res.setUser(user);

		if (stepCountData != null) {
			Map<String, Object> response = new HashMap<>();
			response.put("statusMessage", "Success");
			response.put("statusCode", 200);
			response.put("data", res);

			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			
			Map<String, Object> response = new HashMap<>();
			response.put("statusMessage", "Fail");
			response.put("statusCode", 404);
			response.put("data", res);

			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}

}