package com.graphql.tutorial.resolvers;

//import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphql.tutorial.models.Article;
import com.graphql.tutorial.models.User;
//import com.graphql.tutorial.repository.ArticleRepository;
import com.graphql.tutorial.repository.UserRepository;

//import org.springframework.beans.factory.annotation.Autowired;

public class ArticleResolver implements GraphQLResolver<Article> {

    private UserRepository userRepo;

    public ArticleResolver(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User getAuthor(Article article) {
        return userRepo.findOne(article.getAuthor().getId());
    }
}