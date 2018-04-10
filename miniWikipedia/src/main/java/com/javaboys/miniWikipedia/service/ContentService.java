package com.javaboys.miniWikipedia.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.javaboys.miniWikipedia.dto.ContentDto;
import com.javaboys.miniWikipedia.exception.UserCreateException;
import com.javaboys.miniWikipedia.model.Content;
import com.javaboys.miniWikipedia.model.User;
import com.javaboys.miniWikipedia.repository.ContentRepository;
import com.javaboys.miniWikipedia.repository.UserRepository;
import com.javaboys.miniWikipedia.response.ContentResponse;
import com.javaboys.miniWikipedia.utilities.EncodeBase64;
import com.javaboys.miniWikipedia.utilities.RandomNumber;

@Service
public class ContentService {
	@Autowired
	ContentRepository contentRepository;
	@Autowired
	UserRepository userRepository;
	
	
	public void createContent(Long userId, ContentDto contentDto, String encodedImage) {
		Content content = new Content();
		User user = userRepository.findByUserId(userId);
		User aaa = userRepository.findByUserId(userId);
		
		if(aaa == null) {
		throw new UserCreateException("No Such User ID in Database!!");
	    }
			

		
		Content check = contentRepository.findByContentName(contentDto.getContentName());
		if(check != null) {
			throw new UserCreateException(contentDto.getContentName()+" ContentName already exits");

		}
		content.setContentName(contentDto.getContentName());
		content.setDescription(contentDto.getDescription());
		content.setContentToken(RandomNumber.getRandomString());
		content.setImage(EncodeBase64.decoder(encodedImage));
		content.setUserName(contentDto.getUserName());
		content.setUser(user);
		contentRepository.save(content);
	
	}
	
	
	public ContentResponse getContent(Long contentId) {
		Content abcd = contentRepository.findByContentId(contentId);
	    if(abcd == null) {
			throw new UserCreateException("No Content Exits");
	
		  }
	    
		Content content = contentRepository.getOne(contentId);
		
		ContentResponse contentResponse = new ContentResponse();
		contentResponse.setContentId(content.getContentId());
		contentResponse.setContentName(content.getContentName());
		contentResponse.setContentToken(content.getContentToken());
		contentResponse.setUserName(content.getUserName());
		contentResponse.setDescription(content.getDescription());
		return contentResponse;
		
	}
	
	public Content updateContent(Long contentId, ContentDto contentDto , Long userId) {
		
		Content sss = contentRepository.findByContentName(contentDto.getContentName());
		User uuu = userRepository.findByUserId(userId);
		Content ccc = contentRepository.findByContentId(contentId);	
		if(ccc == null) {
			throw new UserCreateException("No Such Content Id in Database!!");
		}
		
		if(sss != null) {
			throw new UserCreateException("Content Name already exits");
			
		}
		if(uuu == null) {
			throw new UserCreateException("No Such user Id in Database!!");
		}
		
		Content content = new Content();
				content.setContentName(contentDto.getContentName());
				content.setUserName(contentDto.getUserName());
				content.setDescription(contentDto.getDescription());
				
				content = contentRepository.save(content);
				return content;
			}
		
	
	public void deleteContent(Long contentId) {
		Content abcd = contentRepository.findByContentId(contentId);
	    if(abcd == null) {
			throw new UserCreateException("No Content Exits");
	
		  }
		contentRepository.deleteById(contentId);

		}	
	    public List<ContentResponse> getcontentbyuserId(Long userId){
		User user = userRepository.getByUserId(userId);
		
		if(user == null) {
			throw new  UserCreateException("No any contents associated with...");
		}
	    
		List<Content> content = contentRepository.findByUser(user);
	    List<ContentResponse> contentResponse = new ArrayList<>();
		for(Content c:content) {
			ContentResponse response=new ContentResponse();
			response.setContentId(c.getContentId());
			response.setContentName(c.getContentName());
			response.setDescription(c.getDescription());
			response.setUserName(c.getUserName());
			response.setContentToken(c.getContentToken());
		    contentResponse.add(response);
		}
		return contentResponse;
	}

	public Map<Object, Object> getallcontents() {
		
		List<Content> content = contentRepository.findAll();
		List<ContentResponse> contentResponse = new ArrayList();
		for(Content c:content) {
			ContentResponse response = new ContentResponse();
			response.setContentId(c.getContentId());
			response.setContentName(c.getContentName());
			response.setDescription(c.getDescription());
			response.setContentToken(c.getContentToken());
		    contentResponse.add(response);
		}
		Map<Object, Object> responseMap = new HashMap<Object, Object>();
		responseMap.put("All Contents", contentResponse);
		return responseMap;
	}
}


