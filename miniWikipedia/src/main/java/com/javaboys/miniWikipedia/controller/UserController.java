package com.javaboys.miniWikipedia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaboys.miniWikipedia.dto.UserDto;
import com.javaboys.miniWikipedia.model.User;
import com.javaboys.miniWikipedia.response.ContentResponse;
import com.javaboys.miniWikipedia.response.UserResponse;
import com.javaboys.miniWikipedia.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestBody UserDto userDto){
		userService.createUser(userDto);
	    return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Object> readUser(@PathVariable Long userId){
		UserResponse userResponse = userService.getUser(userId);
		Map<Object, Object> responseMap = new HashMap<Object, Object>();
		responseMap.put("response",userResponse);
		return new ResponseEntity<Object>(responseMap, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/{userId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateUser(@PathVariable Long userId,  @RequestBody UserDto userDto){
		User user = userService.updateUser(userId, userDto);
		Map<Object, Object> responseMap = new HashMap<Object, Object>();
		responseMap.put("response", user);
		return new ResponseEntity<Object>(responseMap,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> userDelete(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<Object>("Deleted",HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getallusers(){
		Map<Object, Object> responseMap = userService.getallusers();
		return new ResponseEntity<Object>(responseMap, HttpStatus.OK);
		
	}
	

}
