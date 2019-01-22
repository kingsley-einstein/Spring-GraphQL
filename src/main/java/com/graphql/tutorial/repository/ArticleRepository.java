package com.graphql.tutorial.repository;

import com.graphql.tutorial.models.Article;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {}