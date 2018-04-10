package com.javaboys.miniWikipedia.response;

public class ContentResponse {

	private Long contentId;
	private String description;
	private String contentName;
	private String userName;
	private String contentToken;
	

	public Long getContentId() {
		return contentId;
	}
	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}
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
	public String getContentToken() {
		return contentToken;
	}
	public void setContentToken(String contentToken) {
		this.contentToken = contentToken;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}

