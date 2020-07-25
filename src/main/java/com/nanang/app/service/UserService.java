package com.nanang.app.service;

import java.util.List;

import com.nanang.app.model.UserModel;

public interface UserService {

	int save(UserModel user);
	int update(UserModel user);
	int delete(String id);
	List<UserModel> list();
	UserModel findOne(String id);
	
	
	
}
