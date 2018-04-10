package com.javaboys.miniWikipedia.dto;

import java.io.Serializable;

public class ContentDto implements Serializable{
	
	
	private String description;
	private String contentName;
	private String userName;
	
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getContentName() {
		return contentName;
	}
	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
