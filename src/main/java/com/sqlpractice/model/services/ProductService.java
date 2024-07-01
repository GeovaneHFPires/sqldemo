package com.sqlpractice.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqlpractice.model.entities.Product;
import com.sqlpractice.model.repositories.ProductRepository;
import com.sqlpractice.model.services.Exceptions.ResourceNotFoundException;

@Service
public class ProductService{

    @Autowired
    private ProductRepository prodRepo;


    public List<Product> findAll(){
        return prodRepo.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = prodRepo.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
