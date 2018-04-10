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

import com.javaboys.miniWikipedia.dto.ContentDto;
import com.javaboys.miniWikipedia.model.Content;
import com.javaboys.miniWikipedia.model.User;
import com.javaboys.miniWikipedia.repository.ContentRepository;
import com.javaboys.miniWikipedia.response.ContentResponse;
import com.javaboys.miniWikipedia.service.ContentService;

@RestController
@RequestMapping("/content")
public class ContentController {
	@Autowired
	ContentService contentService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createContent(@RequestParam Long userId, @RequestBody ContentDto contentDto, @RequestParam String encodedImage){
		contentService.createContent(userId,contentDto,encodedImage);
		return new ResponseEntity<Object>("Content Created", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{contentId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getContent(@PathVariable Long contentId){
		ContentResponse contentResponse = contentService.getContent(contentId);
		Map<Object, Object> responseMap = new HashMap<Object, Object>();
		responseMap.put("response",contentResponse);
		return new ResponseEntity<Object>(responseMap, HttpStatus.OK);
	}
	@RequestMapping(value ="/{contentId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateContent(@PathVariable Long contentId,  @RequestBody ContentDto contentDto, @RequestParam Long userId){
		Content content = contentService.updateContent(contentId, contentDto,userId);
		Map<Object, Object> responseMap = new HashMap<Object, Object>();
		responseMap.put("response", content);
		return new ResponseEntity<Object>(responseMap,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{contentId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteContent(@PathVariable Long contentId) {
		contentService.deleteContent(contentId);
		return new ResponseEntity<Object>("Deleted",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getcontentbyuserId", method = RequestMethod.GET)
	public ResponseEntity<Object> getcontentbyuserId(@RequestParam Long userId){
		List<ContentResponse> content = contentService.getcontentbyuserId(userId);
		Map<Object, Object> responseMap = new HashMap<Object, Object>();
		responseMap.put("particular contents", content);
		return new ResponseEntity<Object>(responseMap, HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getallcontents(){
		Map<Object, Object> responseMap = contentService.getallcontents();
		return new ResponseEntity<Object>(responseMap, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	}

