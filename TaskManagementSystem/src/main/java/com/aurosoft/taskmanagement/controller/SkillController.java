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

import com.aurosoft.taskmanagement.entity.Skill;
import com.aurosoft.taskmanagement.service.SkillService;

@Controller
@RequestMapping("/skill")
public class SkillController {

	@Autowired
	SkillService skillService;
	

	

	public SkillController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}

	@GetMapping("/list")
	public  String listSkills(Model m)
	{
		List<Skill> list = skillService.listAllSkills();
		m.addAttribute("list",list);
		return "/Skill/list";
	}
	
	@GetMapping("/new")
	public String showForm(Skill skill)
	{
		return "/Skill/add";
	}
	
	@PostMapping("/insert")
	public String insertSkill(@ModelAttribute("skill") Skill skill)
	{
		skillService.insertSkill(skill);
		return "redirect:/skill/list";
	}
	
	@GetMapping(value="/edit/{id}")
	public String editSkill(@PathVariable int id,Model m)
	{
		
	Skill skill=skillService.getSkillbyId(id);
	m.addAttribute("skill", skill);
	return "/Skill/edit";
	}
	
	
	@PostMapping(value="/update")
	public String updateSkill(@ModelAttribute("skill") Skill skill)
	{
		skillService.updateSkill(skill);
		return "redirect:/skill/list";
	}
	
	@GetMapping(value="/delete/{id}")
	public String deleteSkill(@PathVariable int id, Model m)
	
	{
		skillService.deleteSkill(id);
		return "redirect:/skill/list";
	}
}