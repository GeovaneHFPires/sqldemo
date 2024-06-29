package com.sqlpractice.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqlpractice.model.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
