package com.aurosoft.taskmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurosoft.taskmanagement.entity.Skill;
import com.aurosoft.taskmanagement.repository.SkillRepository;
import com.aurosoft.taskmanagement.service.SkillService;
@Service
public class SkillServiceImpl implements SkillService{
@Autowired
	SkillRepository repo;
	
	
	
	@Override
	public List<Skill> listAllSkills() {
	return	repo.findAll();
	}

	@Override
	public Skill getSkillbyId(int id) {
		
		return repo.findById(id).orElseThrow();
	}

	@Override
	public Skill insertSkill(Skill skill) {
		
		return repo.save(skill);
	}

	@Override
	public Skill updateSkill(Skill skill) {
		
		return repo.save(skill);
	}

	@Override
	public int deleteSkill(int id) {
		repo.deleteById(id);
		return id;
	}

}
