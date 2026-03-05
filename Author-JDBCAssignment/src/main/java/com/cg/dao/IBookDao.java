package com.cg.dao;

import com.cg.bean.Book;

import java.util.List;

public interface IBookDao {
    public String createBook(Book b);
    public List<Book> booklist(Integer id);
    public String deleteBook(Integer id);
}
