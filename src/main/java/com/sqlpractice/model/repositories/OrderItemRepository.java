package com.sqlpractice.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sqlpractice.model.entities.OrderItem;
import com.sqlpractice.model.entities.PK.OrderItemPK;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
