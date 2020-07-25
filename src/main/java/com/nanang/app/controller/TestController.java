package com.nanang.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

	
	@GetMapping("super")
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
	public String onlySuperAdmin() {
		return "Has Role Super Admin";
	}
	
	@GetMapping("user")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String user() {
		return "akses user";
	}
	
	@GetMapping("admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String admin() {
		return "admin akses";
	}
}
