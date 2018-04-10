package com.javaboys.miniWikipedia.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaboys.miniWikipedia.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);

	User findByUserNameAndPassWord(String userName, String passWord);

	User findByUserId(Long userId);

	User getByUserId(Long userId);

	User findByEmail(String email);

	

	


	
}
