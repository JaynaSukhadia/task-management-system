package com.aurosoft.taskmanagement.entity;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="skills")
public class Skill {

	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id",nullable = false)
	private int id;
	
	
	@Column(name="name",nullable = false)
	private String name;
	
	
	 @ManyToMany(mappedBy = "skills", fetch = FetchType.LAZY)
	    private Set<User> users = new HashSet<>();
	
	
	@Override
    public String toString() {
        return this.name;
    }
 
   
}
