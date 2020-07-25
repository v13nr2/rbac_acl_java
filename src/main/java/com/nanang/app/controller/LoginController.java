package com.nanang.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nanang.app.model.TokenResponse;
import com.nanang.app.model.UserModel;
import com.nanang.app.service.LoginService;

@RestController
@RequestMapping("login")
public class LoginController {

	@Autowired
	private LoginService logSvc;
	
	@PostMapping
	public ResponseEntity<TokenResponse> login(@RequestBody UserModel user){
		TokenResponse response = logSvc.login(user);
		return new ResponseEntity<TokenResponse>(response,HttpStatus.OK);
		
	}
}
