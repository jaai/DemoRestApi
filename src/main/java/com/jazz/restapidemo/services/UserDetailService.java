package com.jazz.restapidemo.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jazz.restapidemo.model.data.Users;

public interface UserDetailService {
	Page<Users> getAllUserData(Pageable pageable);
	
	Users getUserbyEmail(String user_email);
	Users getUserbyTeam(String user_team);
	
}