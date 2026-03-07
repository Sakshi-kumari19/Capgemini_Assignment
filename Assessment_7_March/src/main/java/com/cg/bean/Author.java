package com.cg.bean;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Author {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int author_id;
    private String author_name;
    private String email;
    @OneToMany(mappedBy = "author_id",cascade = CascadeType.ALL)
    private List<Book> books;

    public Author(){}
    public Author(int author_id, String author_name, String email) {
        this.author_id = author_id;
        this.author_name = author_name;
        this.email = email;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
