package com.graphql.tutorial.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.tutorial.models.Article;
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
        return userRepo.save(new User(name, password));
    }

    public User updateName(Long id, String name) {
        User user = userRepo.findOne(id);
        user.setName(name);

        return userRepo.save(user);
    }

    public Boolean updatePW(Long id, String password) {
        User user = userRepo.findOne(id);
        user.setPassword(password);

        userRepo.save(user);

        return true;
    }

    public Boolean deleteUser(Long id) {
        userRepo.delete(id);

        return true;
    }

    public Article newArticle(String title, String content, Long id) {
        Article article = new Article(title, content, userRepo.findOne(id));

        return articleRepo.save(article);
    }

    public Boolean updateArticle(Long id, String title, String content) {
        Article article = articleRepo.findOne(id);
        article.setTitle(title);
        article.setContent(content);

        articleRepo.save(article);

        return true;
    }

    public Boolean deleteArticle(Long id) {
        articleRepo.delete(id);

        return true;
    }
}