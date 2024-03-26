package com.leonardo.workshopmongo.service;

import com.leonardo.workshopmongo.entity.Post;
import com.leonardo.workshopmongo.repository.PostRepository;
import com.leonardo.workshopmongo.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;
    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new NotFoundException(id));
    }

    public Post insert(Post obj){
        Post objSave = postRepository.insert(obj);
        return  objSave;
    }

    public void delete(String id){
        findById(id);
        try {
            postRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e ){
            throw new NotFoundException(id);
        }
    }
    public List<Post> findByTitle(String text){
        return  postRepository.searchTitle(text);
    }
}
