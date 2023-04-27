package com.aurosoft.taskmanagement.service;

import java.util.List;

import com.aurosoft.taskmanagement.entity.Skill;

public interface SkillService {

	List<Skill> listAllSkills();
	Skill getSkillbyId(int id);
	Skill insertSkill(Skill skill);
	Skill updateSkill(Skill skill);
	int deleteSkill(int id);
	
	
	
}
