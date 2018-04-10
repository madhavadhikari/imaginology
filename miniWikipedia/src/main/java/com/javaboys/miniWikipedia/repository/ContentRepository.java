package com.javaboys.miniWikipedia.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaboys.miniWikipedia.model.Content;
import com.javaboys.miniWikipedia.model.User;



@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

	Content findByContentName(String contentName);

	List<Content> findByUser(User user);

	Content findByContentId(Long contentId);

	

	
}
