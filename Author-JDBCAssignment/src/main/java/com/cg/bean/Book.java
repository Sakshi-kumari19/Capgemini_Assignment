package com.cg.bean;

import java.math.BigDecimal;

public class Book {
    private Integer ISBN;
    private String title;
    private Double price;
    private Integer authorId;

    public Book(Integer ISBN, String title, Double price, Integer authorId) {
        this.ISBN = ISBN;
        this.title = title;
        this.price = price;
        this.authorId = authorId;
    }




    public Integer getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getAuthorId() {
        return authorId;
    }
}
