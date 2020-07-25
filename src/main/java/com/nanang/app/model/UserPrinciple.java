package com.nanang.app.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrinciple implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7121511006033037938L;
	private String username;
	private String password; 
	private Collection<? extends GrantedAuthority> authorities;
	
	
	
	
	
	
	
	
	public UserPrinciple() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	public UserPrinciple(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	
	



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public static UserPrinciple newPrinciple(String username, String password, List<String> roles) {
		//generate GrantAuthory from Role
		final List<GrantedAuthority> authoritiesSource = roles.stream().map(s-> {
			return new SimpleGrantedAuthority(s);
		}).collect(Collectors.toList());
		
		UserPrinciple up = new UserPrinciple();
		up.username = username;
		up.password = password;
		up.authorities = authoritiesSource;
		System.out.println("data" + authoritiesSource.toString());
        return up;		
	}
	
	public UserPrinciple build() {
		return new UserPrinciple(username, password, authorities);
	}

}
