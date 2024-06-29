package com.sqlpractice.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sqlpractice.model.entities.User;
import com.sqlpractice.model.repositories.UserRepository;
import com.sqlpractice.model.services.Exceptions.DatabaseException;
import com.sqlpractice.model.services.Exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException (id));
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }

    }

    
    public User update(Long id, User user){
        try {
            User obj = repository.getReferenceById(id);
            updateData(obj, user);
            return repository.save(obj);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }


    }

    private void updateData(User obj, User user){
        obj.setEmail(user.getEmail());
        obj.setName(user.getName());
        obj.setPhone(user.getPhone());
    }

}
