package com.aurosoft.taskmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurosoft.taskmanagement.entity.Department;
import com.aurosoft.taskmanagement.repository.DepartmentRepository;
import com.aurosoft.taskmanagement.service.DepartmentService;

@Service
public class DepartmentServiceImpl  implements DepartmentService{

	@Autowired
	DepartmentRepository repository;

	
	@Override
	public List<Department> listAllDepartments() {
		
		
		return repository.findAll();
	}

	@Override
	public Department getDepartmentByID(int id) {
		
		return repository.findById(id).orElseThrow();
	}

	@Override
	public void insertDepartment(Department department) {
		
		repository.save(department);
	}

	@Override
	public void updateDepartment(Department department) {
		
		repository.save(department);
	}

	@Override
	public int deleteDepartment(int id) {
		repository.deleteById(id);
		return id;
	}

}
