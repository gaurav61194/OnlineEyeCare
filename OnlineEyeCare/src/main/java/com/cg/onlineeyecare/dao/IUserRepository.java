package com.cg.onlineeyecare.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineeyecare.entity.User;

public interface IUserRepository extends JpaRepository<User,Integer>{
	Optional<User> findByuserName(String name);
}
