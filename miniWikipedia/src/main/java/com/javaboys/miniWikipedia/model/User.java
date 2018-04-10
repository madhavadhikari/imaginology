package com.javaboys.miniWikipedia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import com.javaboys.miniWikipedia.utilities.LoginStatus;




@Entity
@Table(name="user")
public class User implements Serializable {
	@Column(name = "userId")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	private String fullName;
	private String userName;
	private String passWord;
	private String token;
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(name = "loginStatus")
	@Value("LoginStatus.LOGGED_OUT")
	private LoginStatus status;
	
	
	
	@OneToMany(mappedBy = "user")
	private List<Content> content;
	
	
	
	public List<Content> getContent() {
		return content;
	}
	public void setContent(List<Content> content) {
		this.content = content;
	}
	

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public LoginStatus getStatus() {
		return status;
	}
	public void setStatus(LoginStatus status) {
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
	
}
