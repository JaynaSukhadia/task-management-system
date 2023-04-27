package com.aurosoft.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aurosoft.taskmanagement.entity.Department;
import com.aurosoft.taskmanagement.entity.Project;
import com.aurosoft.taskmanagement.entity.User;
import com.aurosoft.taskmanagement.service.DepartmentService;
import com.aurosoft.taskmanagement.service.ProjectService;
import com.aurosoft.taskmanagement.service.UserService;

@Controller
@RequestMapping("/project")

public class ProjectController {

	@Autowired
private	ProjectService projectService;
	@Autowired
private	UserService userService;
	@Autowired
private	DepartmentService departmentService;

	
	
	public ProjectController(ProjectService projectService, UserService userService,
			DepartmentService departmentService) {
		super();
		this.projectService = projectService;
		this.userService = userService;
		this.departmentService = departmentService;
	}



	@GetMapping("/list")
	public String listAllProject(Model m)
	{
		List<Project> list =projectService.listAllProjects();
		m.addAttribute("list",list);
		return "/Project/list";
	}
	
	@GetMapping("/new")
	public String showForm(Project project, Model m)
	{
		
		List<Department> list = departmentService.listAllDepartments();
		m.addAttribute("departmentlist",list);
		
		List<User> list1 = userService.listAllUsers();
		m.addAttribute("userlist",list1);
		
		return "/Project/add";
	}
	
	@PostMapping("/insert")
	public String insertProject(@ModelAttribute("project")Project project)
	{
		projectService.insertProject(project);
		return "redirect:/project/list";
	}
	
	@GetMapping(value="/edit/{id}")
	public String editProject(@PathVariable int id,Model m)
	{
		Project project = projectService.getProjectById(id);
		m.addAttribute("project", project);
		
		
		List<Department> list = departmentService.listAllDepartments();
		m.addAttribute("departmentlist",list);
		
		List<User> list1 = userService.listAllUsers();
		m.addAttribute("userlist",list1);
		
		return "Project/edit";
	}
	
	@PostMapping(value="/update")
	public String updateProject(@ModelAttribute("project")Project project)
	{
		
		projectService.updateProject(project);
		return "redirect:/project/list";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String deleteProject(@PathVariable int id)
	{
		projectService.deleteProject(id);
		return "redirect:/project/list";
	}
	
}
