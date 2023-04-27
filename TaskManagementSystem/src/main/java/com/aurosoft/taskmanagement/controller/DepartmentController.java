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
//import com.aurosoft.taskmanagement.repository.DepartmentRepository;
import com.aurosoft.taskmanagement.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	//DepartmentRepository repository;
	@Autowired
	DepartmentService departmentService;
	

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}

	@GetMapping("/list")
	public  String listDepartments(Model m)
	{
		List<Department> list = departmentService.listAllDepartments();
		m.addAttribute("list",list);
		return "/department/list";
	}
	
	@GetMapping("/new")
	public String showForm(Department department)
	{
		return "/department/add";
	}
	
	@PostMapping("/insert")
	public String insertDepartment(@ModelAttribute("department") Department department)
	{
		departmentService.insertDepartment(department);
		return "redirect:/department/list";
	}
	
	@GetMapping(value="/edit/{id}")
	public String editDepartment(@PathVariable int id,Model m)
	{
		
	Department department=departmentService.getDepartmentByID(id);
	m.addAttribute("department", department);
	return "/department/edit";
	}
	
	
	@PostMapping(value="/update")
	public String updateDepartment(@ModelAttribute("department") Department department)
	{
		departmentService.updateDepartment(department);
		return "redirect:/department/list";
	}
	
	@GetMapping(value="/delete/{id}")
	public String deleteDepartment(@PathVariable int id, Model m)
	
	{
		departmentService.deleteDepartment(id);
		return "redirect:/department/list";
	}
}
