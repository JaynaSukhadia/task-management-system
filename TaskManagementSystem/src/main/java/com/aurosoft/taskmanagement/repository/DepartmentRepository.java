package com.aurosoft.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.taskmanagement.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
