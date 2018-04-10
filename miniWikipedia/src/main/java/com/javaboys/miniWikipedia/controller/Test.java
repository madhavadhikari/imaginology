
package com.javaboys.miniWikipedia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gethelloworld")
public class Test {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object>getUsers(){
		return new ResponseEntity<Object>("Hello World", HttpStatus.OK);
	}
}
