package com.nanang.app.service;

import com.nanang.app.model.TokenResponse;
import com.nanang.app.model.UserModel;

public interface LoginService {

	TokenResponse login(UserModel user);
}
