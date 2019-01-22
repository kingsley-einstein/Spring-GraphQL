package com.graphql.tutorial.repository;

import com.graphql.tutorial.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}