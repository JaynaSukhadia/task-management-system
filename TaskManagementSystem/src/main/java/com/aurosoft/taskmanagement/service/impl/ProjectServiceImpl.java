package com.aurosoft.taskmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurosoft.taskmanagement.entity.Project;
import com.aurosoft.taskmanagement.repository.ProjectRepository;
import com.aurosoft.taskmanagement.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
@Autowired
	ProjectRepository repo;
	@Override
	public List<Project> listAllProjects() {
		
		return repo.findAll();
	}

	@Override
	public Project getProjectById(int id) {
		
		return repo.findById(id).orElseThrow();
	}

	@Override
	public Project insertProject(Project project) {
		
		return repo.save(project);
	}

	@Override
	public Project updateProject(Project project) {
		
		return repo.save(project);
	}

	@Override
	public int deleteProject(int id) {
		repo.deleteById(id);
		return id;
	}

}
