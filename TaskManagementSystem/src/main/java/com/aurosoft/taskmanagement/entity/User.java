package com.aurosoft.taskmanagement.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name= "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private int id;
	
	@Column(name="name", nullable= false)
	private String name;
	
	@Column(name="email", nullable = false)
	private String email;
	
	@Column(name="password", nullable =  false)
	private String password;
	
	@Column(name="gender", nullable =  false)
	private String gender;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="role_id", referencedColumnName = "id", nullable = false)
	private Role role;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="department_id", referencedColumnName = "id", nullable = false)
	private Department department;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_skills",
            joinColumns = { @JoinColumn(name = "user_id",referencedColumnName = "id",
            nullable = false, updatable = false)},
            inverseJoinColumns = { @JoinColumn(name = "skill_id", referencedColumnName = "id",
            nullable = false, updatable = false)})
            
    private Set<Skill> skills = new HashSet<>();

	
	
	
	
	@Column(name="entry_date", nullable=false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date entry_date;
	
	@Column(name="logout", nullable=false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date logout;
	
	@Column(name="photo", nullable=false)
	private String photo;
	
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY)
	private Set<Project> projectlist = new HashSet<>();
	
	
	
	 
	
	
	@Transient
    public String getPhotosImagePath() {
        if (photo == null || id == 0) return null;
         
        return "/user-photos/" + id + "/" + photo;
    }

	
	
	
	
	
	
	
}
