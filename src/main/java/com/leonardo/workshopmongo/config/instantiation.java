package com.leonardo.workshopmongo.config;

import com.leonardo.workshopmongo.entity.Post;
import com.leonardo.workshopmongo.entity.User;
import com.leonardo.workshopmongo.repository.PostRepository;
import com.leonardo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

public class instantiation implements CommandLineRunner {

    @Autowired
    UserRepository repository;

    @Autowired
    PostRepository postRepositorys;

    @Override
    public void run(String... args) throws Exception {


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        repository.deleteAll();
        postRepositorys.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null,sdf.parse("21/03/2018"),"partiu viagem","vou viajar pra SP",maria);

        repository.saveAll(Arrays.asList(maria,alex,bob));
        postRepositorys.saveAll(Arrays.asList(post1));
    }
}
