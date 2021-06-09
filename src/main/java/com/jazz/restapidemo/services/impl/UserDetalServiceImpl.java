package com.jazz.restapidemo.services.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jazz.restapidemo.model.data.Users;
import com.jazz.restapidemo.repository.UsersRepo;
import com.jazz.restapidemo.services.UserDetailService;

@Service
public class UserDetalServiceImpl implements UserDetailService {
	@Autowired
	UsersRepo usersRepo;

	@Override
	public Users getUserbyEmail(String user_email) {
		Users userData = usersRepo.findUserByEmail(user_email);
		return userData;
	}

	@Override
	public Page<Users> getAllUserData(Pageable pageable) {
		Long allUsersRecord = usersRepo.getAllUserDataCount();
		List<Users> userDataList = usersRepo.findAllData(pageable);
		Page<Users> UsersPage = new PageImpl<Users>(userDataList, pageable, allUsersRecord);
		return UsersPage;
	}

	@Override
	public Users getUserbyTeam(String user_team) {
		Users userData = usersRepo.findUserByTeam(user_team);
		return userData;
	}

}