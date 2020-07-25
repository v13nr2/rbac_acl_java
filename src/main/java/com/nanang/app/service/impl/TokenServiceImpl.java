package com.nanang.app.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nanang.app.model.TokenRequest;
import com.nanang.app.model.TokenResponse;
import com.nanang.app.security.jwt.JwtProvider;
import com.nanang.app.service.TokenService;
import com.nanang.app.utility.Konstanta;
import com.nanang.app.utility.Utility;


@Service
public class TokenServiceImpl implements TokenService {
	
	@Value("${keys.clientId}")
	private String clientIdParam;
	@Value("${keys.secret}")
	private String SecretkeyParam;

	
	
	@Value("${keys.jwtSecret}")
	private String jwtSecret;

    
	@Value("${keys.regex1}")
    private String regex1;
 
	@Value("${keys.regex2}")
    private String regex2;

	@Autowired
    private JwtProvider jwtProvider;
	
	@Override
	public TokenResponse getToken(TokenRequest token) {
		// TODO Auto-generated method stub
		final String clientId = token.getClientId() ==null?"":token.getClientId();
		final String secretKey = token.getSecret() ==null?"":token.getSecret();
		TokenResponse tokenResponse = new TokenResponse();
		
	    //jika sesuai generate Token
		if(clientIdParam.equals(clientId) && SecretkeyParam.equals(secretKey)) {
			List<String> roleString = Arrays.asList("ROLE_ADMIN","ROLE_USER");
			String bodyToken = Utility.buildingBodyTokenUserIdAndRole(clientId, regex1, roleString, regex2);
			String tokenData = jwtProvider.generateJwtTokenCustom(bodyToken);
			tokenResponse.setStatus(Konstanta.SUCCESSHTTPOK);
			tokenResponse.setToken(tokenData);
	    }	
		
		
		return tokenResponse;
	}

}
