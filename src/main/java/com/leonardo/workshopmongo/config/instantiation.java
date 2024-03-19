package com.leonardo.workshopmongo.config;

import com.leonardo.workshopmongo.dto.AuthorDto;
import com.leonardo.workshopmongo.dto.CommentDto;
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
    UserRepository userRepository;

    @Autowired
    PostRepository postRepositorys;

    @Override
    public void run(String... arg0) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepositorys.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDto(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDto(maria));

        CommentDto c1 = new CommentDto("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDto(alex));
        CommentDto c2 = new CommentDto("Aproveite", sdf.parse("22/03/2018"), new AuthorDto(bob));
        CommentDto c3 = new CommentDto("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDto(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepositorys.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }

}
