package com.javaboys.miniWikipedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaboys.miniWikipedia.dto.LoginDto;
import com.javaboys.miniWikipedia.model.User;
import com.javaboys.miniWikipedia.repository.UserRepository;
import com.javaboys.miniWikipedia.utilities.LoginStatus;
import com.javaboys.miniWikipedia.utilities.EncodeDecode;


@Service
public class LoginService {
	@Autowired
	UserRepository userRepository;
	
 public void checkLogin(LoginDto loginDto) {
	 
	 EncodeDecode decode = new EncodeDecode();
	 User user = new User();
	 User check = userRepository.findByUserNameAndPassWord(loginDto.getUserName(), decode.doEncode(loginDto.getPassWord()));
	 
	 if(check != null){
		 check.setStatus(LoginStatus.LOGGED_IN);
		 userRepository.save(check);
	 }
	 else
	 {
		 System.out.println("Not Logged In");
		 

	 }
	 }
}
