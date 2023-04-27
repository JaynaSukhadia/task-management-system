package com.aurosoft.taskmanagement.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="departments")
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable =  false)
	private  int id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="description" ,  nullable = false)
	private String description;
	
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private Set<Role> rolelist = new HashSet<>();
	
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private Set<User> userlist = new HashSet<>();
	
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private Set<Project> projectlist = new HashSet<>();

	

	
	
	
	
	
	
	
}
