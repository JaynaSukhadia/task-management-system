package com.aurosoft.taskmanagement.service;

import java.util.List;

import com.aurosoft.taskmanagement.entity.Role;

public interface RoleService {
	
	List<Role> listAllRoles();
	Role getRoleById(int id);
	void insertRole(Role role);
	void updateRole(Role role);
	int deleteRole(int id);
	
	

}
