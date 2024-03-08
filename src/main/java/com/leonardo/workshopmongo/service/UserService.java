package com.leonardo.workshopmongo.service;

import com.leonardo.workshopmongo.entity.User;
import com.leonardo.workshopmongo.repository.UserRepository;
import com.leonardo.workshopmongo.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new NotFoundException(id));
    }

    public User insert(User obj){
        User objSave = userRepository.insert(obj);
        return  objSave;
    }
}
