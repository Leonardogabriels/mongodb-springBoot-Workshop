package com.leonardo.workshopmongo.repository;

import com.leonardo.workshopmongo.entity.Post;
import com.leonardo.workshopmongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
}
