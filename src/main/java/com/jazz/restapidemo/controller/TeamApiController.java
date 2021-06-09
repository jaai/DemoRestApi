package com.jazz.restapidemo.controller;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TeamApiController {
	ResponseEntity<Map<String, Object>> getAllTeamData(Pageable pageable);


	ResponseEntity<Map<String, Object>> getOneTeamData(String team_name);


}