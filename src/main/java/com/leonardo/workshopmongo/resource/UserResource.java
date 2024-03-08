package com.leonardo.workshopmongo.resource;

import com.leonardo.workshopmongo.dto.UserDto;
import com.leonardo.workshopmongo.entity.User;
import com.leonardo.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    UserService service;
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        List<UserDto> userDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        User user = service.findById(id);
        return ResponseEntity.ok().body(new UserDto(user));
    }
}
