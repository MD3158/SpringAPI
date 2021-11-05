package com.example.springcrud.service;

import com.example.springcrud.entity.User;
import com.example.springcrud.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired private UserRepository userRepository;

    @Override
    public List<User> getAllUser(){
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findUserById(Integer id){
        return userRepository.findById(id);
    }
}
