package com.graphql.tutorial;

import com.graphql.tutorial.repository.ArticleRepository;
import com.graphql.tutorial.repository.UserRepository;
import com.graphql.tutorial.resolvers.ArticleResolver;
import com.graphql.tutorial.resolvers.Mutation;
import com.graphql.tutorial.resolvers.Query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphQLApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQLApplication.class, args);
    }
    
    @Bean
    public Mutation mutation() {
        return new Mutation();
    }

    @Bean
    public Query query() {
        return new Query();
    }

    @Bean
    public ArticleResolver articleResolver(UserRepository userRepo) {
        return new ArticleResolver(userRepo);
    }

}

