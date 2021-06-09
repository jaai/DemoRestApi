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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jazz.restapidemo.controller.UserApiController;
import com.jazz.restapidemo.model.data.Users;
import com.jazz.restapidemo.repository.UsersRepo;
import com.jazz.restapidemo.services.StepCountService;
import com.jazz.restapidemo.services.UserDetailService;
@RestController
@RequestMapping("v1/stepcount/users")
public class UserApiControllerImpl implements UserApiController{

	@Autowired
	UserDetailService  userDetailService;
	
	@Autowired
	UsersRepo usersRepo;
	
	@Autowired
	StepCountService stepCountService;
	
	@Override
	@GetMapping(value = "/allData")
	public ResponseEntity<Map<String, Object>> getAllUserData(Pageable pageable) {
		Page<Users> UsersDataList = userDetailService.getAllUserData(pageable);

		if (UsersDataList.getContent().size() > 0) {

			Map<String, Object> response = new HashMap<>();
			response.put("statusMessage", "Success");
			response.put("statusCode", 200);
			response.put("data", UsersDataList);

			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {

			Map<String, Object> response = new HashMap<>();
			response.put("statusMessage", "Fail");
			response.put("statusCode", 404);
			response.put("data", null);

			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping(value = "/saveUser")
	public ResponseEntity<Map<String, Object>> saveUser(@RequestBody Users user) {
		List<Users> users=usersRepo.findUserByEmailArr(user.getUserEmail());
		if(users!=null) {
			usersRepo.deleteInBatch(users);
		}
		Users userinfo = usersRepo.save(user);
		if (userinfo != null) {
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
	@GetMapping(value = "/{user_email}")
	public ResponseEntity<Map<String, Object>> getUserbyEmail(String user_email) {
		//StepCountData stepCountData = stepCountService.getUserStepCount(user_email);
		Users user = userDetailService.getUserbyEmail(user_email);
		
		if (user != null) {
			Map<String, Object> response = new HashMap<>();
			response.put("statusMessage", "Success");
			response.put("statusCode", 200);
			response.put("data", user);

			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			Map<String, Object> response = new HashMap<>();
			response.put("statusMessage", "Fail");
			response.put("statusCode", 404);
			response.put("data", null);

			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	
	

	

}