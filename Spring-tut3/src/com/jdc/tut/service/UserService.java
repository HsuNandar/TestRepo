package com.jdc.tut.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.tut.LibraryException;
import com.jdc.tut.entity.User;
import com.jdc.tut.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	
	public User findByLogin(String name,String pass) {
		
		if(StringUtils.isEmpty(name)) {
			throw new LibraryException("Please Type your login_id");
		}
		
		if(StringUtils.isEmpty(pass)) {
			throw new LibraryException("Please Type your password");
		}
		
		User user=repo.findByLoginId(name);
		
		if(user==null) {
			throw new LibraryException("Please check your user name");
		}
		if(!user.getPassword().equals(pass)) {
			throw new LibraryException("Please check your password");
		}
		
		return user;
		
	}


	public String save(User user, String cf) {
		if(StringUtils.isEmpty(user.getName())) {
			throw new LibraryException("Plase enter User Name");
		}
		if(StringUtils.isEmpty(user.getLoginId())) {
			throw new LibraryException("Plase enter Login Id");
		}
		if(StringUtils.isEmpty(user.getRole())) {
			throw new LibraryException("Plase select User Role");
		}
		if(StringUtils.isEmpty(user.getPassword())) {
			throw new LibraryException("Plase enter Password");
		}
		if(!user.getPassword().equals(cf) ){
			throw new LibraryException("Plase confirm your password");
		}
		
		User userLogin=repo.findByLoginId(user.getLoginId());
		
		if(userLogin!=null) {
			throw new LibraryException("Plase Check your Login Id");
		}
			
			repo.save(user);
			return "Success fully Save";
		}

	public List<User> findAll() {
		
		List<User>list=new ArrayList<User>();
		list.addAll(repo.findAll());
		
		return list;
	}


	}

