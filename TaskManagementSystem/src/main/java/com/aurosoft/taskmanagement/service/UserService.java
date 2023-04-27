package com.aurosoft.taskmanagement.service;

import java.util.List;

import com.aurosoft.taskmanagement.entity.User;



public interface UserService {


	List<User> listAllUsers();
	User  getUserById(int id);
	User insertUser(User user);
	User updateUser(User user);
	int deleteUser(int id);
	
}
