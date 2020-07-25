package com.nanang.app.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nanang.app.entity.AauthUsers;
import com.nanang.app.model.UserPrinciple;
import com.nanang.app.repository.AauthUsersRepository;
import com.nanang.app.utility.Utility;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Value("${keys.regex1}")
    private String regex1;
 
	@Value("${keys.regex2}")
    private String regex2;
    @Autowired
	private AauthUsersRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Map<String,Object> data = Utility.extractUserIdAndRoleFromBodyToken(username, this.regex1,this.regex2);
		final String userId = (String) data.get("userid");
		final List<String> roles = getRoles(userId);
		//final List<String> roles = (List<String>) data.get("roles");	
		return UserPrinciple.newPrinciple(userId , "", roles);

	}

	private List<String> getRoles(String userId){
		List<Object[]> listMeta = userRepo.findUserAndGroupByUserId(userId);
		List<String> result = new ArrayList<String>();
		for (Object[] objects : listMeta) {
			 AauthUsers data = (AauthUsers) objects[0];
			 String role = (String) objects[1];
			 System.out.println("Role ==> " + role);
			 result.add(role);
		}
		
		return result;
	}
}
