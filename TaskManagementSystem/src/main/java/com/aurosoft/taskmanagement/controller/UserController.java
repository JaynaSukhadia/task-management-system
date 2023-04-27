package com.aurosoft.taskmanagement.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aurosoft.taskmanagement.FileUploadUtil;
import com.aurosoft.taskmanagement.entity.Department;
import com.aurosoft.taskmanagement.entity.Role;
import com.aurosoft.taskmanagement.entity.Skill;
import com.aurosoft.taskmanagement.entity.User;
import com.aurosoft.taskmanagement.service.DepartmentService;
import com.aurosoft.taskmanagement.service.RoleService;
import com.aurosoft.taskmanagement.service.SkillService;
import com.aurosoft.taskmanagement.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	private DepartmentService departmentService;
	private RoleService roleService;
	private SkillService skillService;
	
	
	
	public UserController(UserService userService, DepartmentService departmentService, RoleService roleService,
			SkillService skillService) {
		super();
		this.userService = userService;
		this.departmentService = departmentService;
		this.roleService = roleService;
		this.skillService = skillService;
	}
	@GetMapping("/list")
	public String listUser(Model m)
	{
  	List<User> list = userService.listAllUsers();
  	m.addAttribute("list", list);
  	return "/user/list";
  	
	}
	@GetMapping("/new")
	public String showForm(User user, Model m)
	{
		List<Department> list= departmentService.listAllDepartments();
		m.addAttribute("listdepartment",list );
		
		List<Role> list1=roleService.listAllRoles();
		m.addAttribute("listrole",list1);
		
		List<Skill> list2 = skillService.listAllSkills();
		m.addAttribute("listskill",list2);
		return "/user/add";
	}
	
	@PostMapping("/insert")
	
	public String insert(User user ,@RequestParam("photo1") MultipartFile multipartFile) throws IOException
	{
		
		//userService.insertUser(user);
	String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	if(fileName.length() > 3 ) {
	user.setPhoto(fileName);
     
    User savedUser = userService.insertUser(user);

    String uploadDir = "./user-photos/" + savedUser.getId();

    FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
	}
     
    else
    {
 	   user.setPhoto("noimg.png");
 	   User savedUser = userService.insertUser(user);
    }
	return "redirect:/user/list";	
	} 
    @GetMapping(value="/edit/{id}")
	public String edit(@PathVariable int id, Model m)
	{
		User user= userService.getUserById(id);
		m.addAttribute("user", user);
		List<Department> list= departmentService.listAllDepartments();
		m.addAttribute("listdepartment",list );
		
		List<Role> list1 = roleService.listAllRoles();
		m.addAttribute("listrole",list1);
		
		List<Skill> list2 = skillService.listAllSkills();
		m.addAttribute("listskill",list2);
		return "user/edit";
		
	}
    
@PostMapping(value="/update")
	
	public String update(User user ,@RequestParam("photo1") MultipartFile multipartFile) throws IOException
	{
	String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	if(fileName.length() > 3 ) {
	user.setPhoto(fileName);
     
    User savedUser = userService.updateUser(user);

    String uploadDir = "./user-photos/" + savedUser.getId();

    FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
	}
     
    else
    {
 	   //user.setPhoto("noimg.png");
 	   User savedUser = userService.updateUser(user);
    }
    return "redirect:/user/list";
	
	} 

@GetMapping(value="/delete/{id}")
public String delete(@PathVariable int id)
{
	userService.deleteUser(id);
	return "redirect:/user/list";
	
}
}
   


	
	 

