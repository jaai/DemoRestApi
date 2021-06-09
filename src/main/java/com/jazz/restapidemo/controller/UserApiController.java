package com.jazz.restapidemo.controller;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface UserApiController {
	ResponseEntity<Map<String, Object>> getAllUserData(Pageable pageable);


	ResponseEntity<Map<String, Object>> getUserbyEmail(String user_email);


}