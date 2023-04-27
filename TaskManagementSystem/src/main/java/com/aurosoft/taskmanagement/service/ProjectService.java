package com.aurosoft.taskmanagement.service;

import java.util.List;

import com.aurosoft.taskmanagement.entity.Project;

public interface ProjectService {

	
	List<Project> listAllProjects();
	Project getProjectById(int id);
	Project insertProject(Project project);
	Project updateProject(Project project);
	int deleteProject(int id);
}
