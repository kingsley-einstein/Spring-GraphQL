package com.graphql.tutorial.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.tutorial.models.User;
import com.graphql.tutorial.repository.ArticleRepository;
import com.graphql.tutorial.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ArticleRepository articleRepo;

    public User newAuthor(String name, String password) {
        return userRepo.save(newAuthor(name, password));
    }

    public User updateName(Long id, String name) {
        User user = userRepo.getOne(id);
        user.setName(name);

        return userRepo.save(user);
    }

    public Boolean updatePW(Long id, String password) {
        User user = userRepo.getOne(id);
        user.setPassword(password);

        userRepo.save(user);

        return true;
    }
}