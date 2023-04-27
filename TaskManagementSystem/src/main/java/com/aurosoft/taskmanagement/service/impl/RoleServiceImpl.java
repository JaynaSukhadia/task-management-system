package com.aurosoft.taskmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurosoft.taskmanagement.entity.Role;
import com.aurosoft.taskmanagement.repository.RoleRepository;
import com.aurosoft.taskmanagement.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository repo;
	
	
	@Override
	public List<Role> listAllRoles() {
		
		return repo.findAll() ;
	}

	@Override
	public Role getRoleById(int id) {
		
		return repo.findById(id).orElseThrow();
	}

	@Override
	public void insertRole(Role role) {
		
		repo.save(role);
		
	}

	@Override
	public void updateRole(Role role) {
		
		repo.save(role);
	}

	@Override
	public int deleteRole(int id) {
		repo.deleteById(id);
		return id;
	}

}
