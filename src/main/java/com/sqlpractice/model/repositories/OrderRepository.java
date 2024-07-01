package com.sqlpractice.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqlpractice.model.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
