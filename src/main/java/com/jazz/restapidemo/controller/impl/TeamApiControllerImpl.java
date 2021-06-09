package com.jazz.restapidemo.controller.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jazz.restapidemo.controller.TeamApiController;
import com.jazz.restapidemo.model.data.Teams;
import com.jazz.restapidemo.model.response.RankApiResponseModel;
import com.jazz.restapidemo.repository.StepCountRepo;
import com.jazz.restapidemo.repository.UsersRepo;
import com.jazz.restapidemo.services.StepCountService;
import com.jazz.restapidemo.services.TeamService;
import com.jazz.restapidemo.services.UserDetailService;

@RestController
@RequestMapping("v1/stepcount/rank")
public class TeamApiControllerImpl implements TeamApiController {

	@Autowired
	UserDetailService userDetailService;
	@Autowired
	StepCountService stepCountService;
	@Autowired
	TeamService teamService;
	@Autowired
	UsersRepo usersRepo;
	@Autowired
	StepCountRepo stepCountRepo;

	@Override
	@GetMapping(value = "/allData")
	public ResponseEntity<Map<String, Object>> getAllTeamData(Pageable pageable) {
		Page<Teams> TeamDataList = teamService.getAllTeamsData(pageable);
		ArrayList<RankApiResponseModel> RankApiResponseModelList = new ArrayList<>();

		for (int i = 0; i < TeamDataList.getContent().size(); i++) {
			RankApiResponseModel rankApiResponseModel = new RankApiResponseModel();
			rankApiResponseModel.setTeamName(TeamDataList.getContent().get(i).getTeamName());
			rankApiResponseModel.setTeamProfilePic(TeamDataList.getContent().get(i).getTeamProfilePic());
			rankApiResponseModel
					.setTeamMembersCount(usersRepo.getTeamDataCount(TeamDataList.getContent().get(i).getTeamName()));
			rankApiResponseModel
					.setTotalSteps(stepCountRepo.getTotalStepCountTeam(TeamDataList.getContent().get(i).getTeamName()));
			RankApiResponseModelList.add(rankApiResponseModel);
		}
		if (RankApiResponseModelList.size() > 0) {

			Map<String, Object> response = new HashMap<>();
			response.put("statusMessage", "Success");
			response.put("statusCode", 200);
			response.put("data", RankApiResponseModelList);

			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {

			Map<String, Object> response = new HashMap<>();
			response.put("statusMessage", "Fail");
			response.put("statusCode", 404);
			response.put("data", null);

			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	@GetMapping(value = "/{team_name}")
	public ResponseEntity<Map<String, Object>> getOneTeamData(@PathVariable("team_name") String team_name) {
		return null;

	}

}