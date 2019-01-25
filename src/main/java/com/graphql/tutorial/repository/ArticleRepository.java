package com.graphql.tutorial.repository;

import java.util.List;

import com.graphql.tutorial.models.Article;
import com.graphql.tutorial.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByAuthor(User author);
}