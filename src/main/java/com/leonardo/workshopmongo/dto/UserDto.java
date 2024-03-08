package com.leonardo.workshopmongo.dto;

import com.leonardo.workshopmongo.entity.User;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    private String id;
    private String name;
    private String email;

    public UserDto(Optional<User> user) {

    }

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    ///f

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto user = (UserDto) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

