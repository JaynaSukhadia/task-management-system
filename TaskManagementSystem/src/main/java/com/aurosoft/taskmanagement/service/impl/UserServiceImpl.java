package com.aurosoft.taskmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.aurosoft.taskmanagement.entity.User;
import com.aurosoft.taskmanagement.repository.UserRepository;
import com.aurosoft.taskmanagement.service.UserService;




@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repo;
	
	@Override
	public List<User> listAllUsers() {
		
		return repo.findAll();
	}

	@Override
	public User getUserById(int id) {
		
		return repo.findById(id).orElseThrow();
	}

	@Override
	public User insertUser(User user) {
		
		return repo.save(user);
	}

	@Override
	public User updateUser(User user) {
		
		return repo.save(user);
	}

	@Override
	public int deleteUser(int id) {
		repo.deleteById(id);
		return id;
	}

	
	
	
}
