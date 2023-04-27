package com.aurosoft.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.taskmanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
