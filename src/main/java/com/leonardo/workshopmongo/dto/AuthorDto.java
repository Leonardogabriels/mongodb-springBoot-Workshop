package com.leonardo.workshopmongo.dto;

import com.leonardo.workshopmongo.entity.User;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

public class AuthorDto implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    private String id;
    private String name;

    public AuthorDto() {

    }

    public AuthorDto(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

