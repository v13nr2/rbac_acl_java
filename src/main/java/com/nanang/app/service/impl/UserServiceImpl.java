package com.nanang.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nanang.app.model.UserModel;
import com.nanang.app.repository.AauthUsersRepository;
import com.nanang.app.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private AauthUsersRepository userRepo;
	
	@Override
	public int save(UserModel user) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int update(UserModel user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserModel> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
