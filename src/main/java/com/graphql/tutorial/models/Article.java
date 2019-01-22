package com.graphql.tutorial.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Table(name = "articles")
@Entity
public class Article implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 30)
    @Column(name = "title", nullable = false)
    private String title;

    @Size(min = 3, max = 19000)
    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    protected Article() {}

    public Article(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }
}