package com.graphql.tutorial.resolvers;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.tutorial.models.Article;
import com.graphql.tutorial.models.User;
import com.graphql.tutorial.repository.ArticleRepository;
import com.graphql.tutorial.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ArticleRepository articleRepo;

    public List<User> getAuthors() {
        return userRepo.findAll();
    }

    public User getById(Long id) {
        return userRepo.findOne(id);
    }

    public List<Article> getArticles() {
        return articleRepo.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepo.findOne(id);
    }
}