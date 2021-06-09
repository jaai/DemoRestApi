package com.jazz.restapidemo.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jazz.restapidemo.model.data.Teams;
public interface TeamService {
	Page<Teams> getAllTeamsData(Pageable pageable);

	Teams getTeamData(String team_name);

	
}