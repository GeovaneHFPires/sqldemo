package com.sqlpractice.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqlpractice.model.entities.OrderItem;
import com.sqlpractice.model.entities.PK.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
