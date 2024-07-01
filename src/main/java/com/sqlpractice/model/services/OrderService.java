package com.sqlpractice.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqlpractice.model.entities.Order;
import com.sqlpractice.model.repositories.OrderRepository;
import com.sqlpractice.model.services.Exceptions.ResourceNotFoundException;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;


    public List<Order> findAll(){
        return orderRepo.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = orderRepo.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }


}
