package com.leonardo.workshopmongo.resource;

import com.leonardo.workshopmongo.entity.User;
import com.leonardo.workshopmongo.repository.UserRepository;
import com.leonardo.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    UserService service;
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List list = service.findAll();
        return ResponseEntity.ok().body(list);

    }
}
