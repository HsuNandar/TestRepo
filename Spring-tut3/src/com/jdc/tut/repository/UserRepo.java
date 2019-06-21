package com.jdc.tut.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.tut.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{


	User findByLoginId(String name);

	
}
