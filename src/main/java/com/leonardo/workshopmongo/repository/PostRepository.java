package com.leonardo.workshopmongo.repository;

import com.leonardo.workshopmongo.entity.Post;
import com.leonardo.workshopmongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
}
