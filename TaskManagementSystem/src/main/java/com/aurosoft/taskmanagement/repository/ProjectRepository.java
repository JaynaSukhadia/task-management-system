package com.aurosoft.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.taskmanagement.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
