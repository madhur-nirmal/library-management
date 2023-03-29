package com.lib.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.main.entity.User;


@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	User findByEmail(String email);
	
}
