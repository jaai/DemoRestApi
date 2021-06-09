package com.jazz.restapidemo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jazz.restapidemo.model.data.Teams;
import com.jazz.restapidemo.repository.TeamRepo;
import com.jazz.restapidemo.services.TeamService;
@Service
public class TeamServiceImpl implements TeamService{
	@Autowired
	TeamRepo teamRepo; 
	
	@Override
	public Page<Teams> getAllTeamsData(Pageable pageable) {
		Long allTeamCount = teamRepo.getAllTeamCount();
		List<Teams> TeamDataList = teamRepo.findAllData(pageable);
		Page<Teams> TeamsDetailPage = new PageImpl<Teams>(TeamDataList, pageable, allTeamCount);
		return TeamsDetailPage;
	}

	@Override
	public Teams getTeamData(String team_name) {
		Teams team = teamRepo.findTeamByName(team_name);
		return team;
	}

}