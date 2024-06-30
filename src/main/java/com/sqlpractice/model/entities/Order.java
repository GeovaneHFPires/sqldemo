package com.sqlpractice.model.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.sqlpractice.model.entities.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();


    
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



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    



}
