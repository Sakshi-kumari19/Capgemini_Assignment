package com.cg.service;

import com.cg.bean.Book;

import java.util.List;

public interface IBookService {
    public String createBook(Book b);
    public List<Book> booklist(Integer id);
    public String deleteBook(Integer id);
}
