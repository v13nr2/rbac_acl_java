package com.nanang.app.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nanang.app.entity.AauthUsers;
import com.nanang.app.model.TokenResponse;
import com.nanang.app.model.UserModel;
import com.nanang.app.repository.AauthUsersRepository;
import com.nanang.app.security.jwt.JwtProvider;
import com.nanang.app.service.LoginService;
import com.nanang.app.utility.Konstanta;
import com.nanang.app.utility.Utility;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AauthUsersRepository userRepo; 
	
	@Autowired
    private JwtProvider jwtProvider;
	
	@Value("${keys.regex1}")
    private String regex1;
 
	@Value("${keys.regex2}")
    private String regex2;
	
	@Override
	public TokenResponse login(UserModel user) {
		// TODO Auto-generated method stub
		TokenResponse response = new TokenResponse();
		String username = user.getUsername() == null? "" : user.getUsername().toString();
		String password = user.getPassword() == null ? "" :user.getPassword().toString();
		List<AauthUsers> listMeta = userRepo.findOneByUsernameAndPassword(username, password);
		if(listMeta.size() >= 1) {
			response.setStatus(Konstanta.SUCCESSHTTPOK);
			String userId = listMeta.get(0).getId();
			List<String> roleString = Arrays.asList("ROLE_META");
			String bodyToken = Utility.buildingBodyTokenUserIdAndRole(userId, regex1, roleString, regex2);
			String token = jwtProvider.generateJwtTokenCustom(bodyToken);
			response.setToken(token);
		}else {
			response.setStatus(Konstanta.SUCCESSHTTPERROR);
		}
		return response;
	}

}
