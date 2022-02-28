package com.course5i.base.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.course5i.base.framework.service.UserDetailsService;

@RestController
public class UserDetailsController {

	@GetMapping("/")
	public String home() {
		return ("<h1>welcome</h1>");
	}
	
	@GetMapping("/user")
	public String user() {
		return ("<h1>welcome user</h1>");
	}
	
	@GetMapping("/admin")
	public String admin() {
		return ("<h1>welcome admin</h1>");
	}
	
}
