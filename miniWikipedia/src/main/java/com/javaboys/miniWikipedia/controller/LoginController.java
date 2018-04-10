package com.javaboys.miniWikipedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaboys.miniWikipedia.dto.LoginDto;
import com.javaboys.miniWikipedia.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController<LoginResponse> {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> getDetail(@RequestBody LoginDto loginDto){
	    loginService.checkLogin(loginDto);
		return new ResponseEntity<Object>("Sucessfully logged in", HttpStatus.OK);
			
	}
}

