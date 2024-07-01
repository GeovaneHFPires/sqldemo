package com.sqlpractice.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqlpractice.model.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
