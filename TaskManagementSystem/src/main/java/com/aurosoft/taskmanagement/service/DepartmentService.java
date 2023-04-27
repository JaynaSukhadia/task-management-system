package com.aurosoft.taskmanagement.service;

import java.util.List;

import com.aurosoft.taskmanagement.entity.Department;

public interface DepartmentService {

	List<Department> listAllDepartments();
	Department getDepartmentByID(int id);
	void insertDepartment(Department department);
	void updateDepartment(Department department);
	int deleteDepartment(int id);
	
	
	
	
}
