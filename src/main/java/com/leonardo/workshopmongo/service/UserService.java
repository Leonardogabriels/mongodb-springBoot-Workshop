package com.leonardo.workshopmongo.service;

import com.leonardo.workshopmongo.entity.User;
import com.leonardo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
