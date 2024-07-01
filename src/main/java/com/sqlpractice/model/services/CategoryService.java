package com.sqlpractice.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqlpractice.model.entities.Category;
import com.sqlpractice.model.repositories.CategoryRepository;
import com.sqlpractice.model.services.Exceptions.ResourceNotFoundException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository catRepo;


    public List<Category> findAll(){
        return catRepo.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = catRepo.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

}
