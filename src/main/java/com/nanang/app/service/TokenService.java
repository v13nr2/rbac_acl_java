package com.nanang.app.service;

import com.nanang.app.model.TokenRequest;
import com.nanang.app.model.TokenResponse;

public interface TokenService {
	
	TokenResponse getToken(TokenRequest token);

}
