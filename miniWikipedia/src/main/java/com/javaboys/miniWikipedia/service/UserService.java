package com.javaboys.miniWikipedia.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaboys.miniWikipedia.dto.UserDto;
import com.javaboys.miniWikipedia.exception.UserCreateException;
import com.javaboys.miniWikipedia.model.Content;
import com.javaboys.miniWikipedia.model.User;
import com.javaboys.miniWikipedia.repository.UserRepository;
import com.javaboys.miniWikipedia.response.ContentResponse;
import com.javaboys.miniWikipedia.response.UserResponse;
import com.javaboys.miniWikipedia.utilities.EncodeDecode;
import com.javaboys.miniWikipedia.utilities.LoginStatus;
import com.javaboys.miniWikipedia.utilities.RandomNumber;

@Service
public class UserService {
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepository;
	
	public void createUser(UserDto userDto) {
		User user = new User();
		User check = userRepository.findByUserName(userDto.getUserName());
		if(check != null) {
			throw new UserCreateException(userDto.getUserName()+" UserName already exits");
	
		}	
		User aaa = userRepository.findByEmail(userDto.getEmail());
		if(aaa != null) {
			throw new UserCreateException(userDto.getEmail()+" Email already exits");
	    }
		
		EncodeDecode encode = new EncodeDecode();
		user.setUserName(userDto.getUserName());
		user.setPassWord(encode.doEncode(userDto.getPassWord()));
		user.setToken(RandomNumber.getRandomString());
		user.setFullName(userDto.getFullName());
		user.setEmail(userDto.getEmail());
		user.setStatus(LoginStatus.LOGGED_OUT);
		 userRepository.save(user);
	}
	
	public UserResponse getUser(Long userId) {
		User abcd = userRepository.findByUserId(userId);
	    if(abcd == null) {
			throw new UserCreateException("No User Exits");
	
		  }
	
		EncodeDecode decode = new EncodeDecode();
		User user = userRepository.getOne(userId);
         UserResponse userResponse = new UserResponse();
		userResponse.setUserName(user.getUserName());
		userResponse.setPassWord(decode.doDecode(user.getPassWord()));
		userResponse.setEmail(user.getEmail());
		userResponse.setToken(user.getToken());
		userResponse.setFullName(user.getFullName());
		return userResponse;
	}
	public User updateUser(Long userId, UserDto userDto) {
		User abcd = userRepository.findByUserId(userId);
	    if(abcd == null) {
			throw new UserCreateException("No User Exits");
	
		  }
	    User check = userRepository.findByUserName(userDto.getUserName());
		if(check != null) {
			throw new UserCreateException(userDto.getUserName()+" UserName already exits");
	
		}	
		User aaa = userRepository.findByEmail(userDto.getEmail());
		if(aaa != null) {
			throw new UserCreateException(userDto.getEmail()+" Email already exits");
	
		}
		User user = userRepository.getOne(userId);
		EncodeDecode encode = new EncodeDecode();
		if(user == null) {
			return null;
		}
		else {
			user.setUserName(userDto.getUserName());
			user.setPassWord(encode.doEncode(userDto.getPassWord()));
			user.setFullName(userDto.getFullName());
			user.setEmail(userDto.getEmail());
			user = userRepository.save(user);
		}
		return user;
	}
	
	public void deleteUser(Long userId) {
		User abcd = userRepository.findByUserId(userId);
	    if(abcd == null) {
			throw new UserCreateException("No User Exits");
	
		  }
		userRepository.deleteById(userId);
	}
	
	public Map<Object, Object> getallusers() {
	
		
		List<User> user = userRepository.findAll();
		List<UserResponse> userResponse = new ArrayList();
		for(User u:user) {
			UserResponse response = new UserResponse();
			response.setUserId(u.getUserId());
			response.setFullName(u.getFullName());
			response.setUserName(u.getUserName());
			EncodeDecode eee = new EncodeDecode();
			response.setPassWord(eee.doDecode(u.getPassWord()));
			response.setEmail(u.getEmail());
		    response.setToken(u.getToken());
		    userResponse.add(response);
		}
		Map<Object, Object> responseMap = new HashMap<Object, Object>();
		responseMap.put("All Users", userResponse);
		return responseMap;
	}
}
