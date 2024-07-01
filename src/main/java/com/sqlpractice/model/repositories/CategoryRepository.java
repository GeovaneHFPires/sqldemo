package com.sqlpractice.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqlpractice.model.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
