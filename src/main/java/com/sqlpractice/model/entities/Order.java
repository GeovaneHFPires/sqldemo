package com.sqlpractice.model.entities;

import java.time.Instant;

import com.sqlpractice.model.entities.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ORDER")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant moment;
    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    
    public Order(Long id, Instant moment, Integer orderStatus) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus;
    }



    public Long getId() {
        return id;
    }



    public Instant getMoment() {
        return moment;
    }



    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }


    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null){
            this.orderStatus = orderStatus.getCode();
        }
        
    }

    



}
