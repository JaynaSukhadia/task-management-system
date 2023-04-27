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
import com.aurosoft.taskmanagement.entity.Role;
import com.aurosoft.taskmanagement.service.DepartmentService;
import com.aurosoft.taskmanagement.service.RoleService;

@Controller
@RequestMapping("/role")

public class RoleController {
@Autowired
	private RoleService roleService;
	private DepartmentService departmentService;



public RoleController(RoleService roleService, DepartmentService departmentService) {
		super();
		this.roleService = roleService;
		this.departmentService = departmentService;
	}
@GetMapping("/list")
public String listAllRole(Model m)
{
	List<Role> list = roleService.listAllRoles();
	m.addAttribute("list",list);
	return "/role/list";
}
@GetMapping("/new")

public String ShowForm(Role role, Model m)
{
	List<Department> list= departmentService.listAllDepartments();
	m.addAttribute("listdepartment",list );
	
	return "/role/add";
}

@PostMapping("/insert")
public String insert(@ModelAttribute("role") Role role)
{
	roleService.insertRole(role);
	
	return "redirect:/role/list";
}

@GetMapping(value="/edit/{id}")
public String edit(@PathVariable int id, Model m)
{
	Role role = roleService.getRoleById(id);
	m.addAttribute("role",role);
	List<Department> list= departmentService.listAllDepartments();
	m.addAttribute("listdepartment",list );
	return "/role/edit";
}

@PostMapping("/update")
public String update(@ModelAttribute("role") Role role)
{
	roleService.updateRole(role);
	return "redirect:/role/list";
}

@GetMapping(value="/delete/{id}")
public String delete(@PathVariable int id)

{
	roleService.deleteRole(id);
	return "redirect:/role/list";
}
}
