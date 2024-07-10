package com.example.library.book;

import java.util.Set;
import java.util.HashSet;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "book", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("book")
    private Set<Comment> comments = new HashSet<>();

    public Book() {
    }

    public Book(String name, Set<Comment> comments) {
        this.name = name;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

}
