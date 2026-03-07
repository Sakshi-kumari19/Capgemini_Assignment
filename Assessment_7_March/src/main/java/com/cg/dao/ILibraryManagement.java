package com.cg.dao;

import com.cg.bean.Author;

public interface ILibraryManagement {
    public void createAuthor(Author a);
    public void readAuthor(int aid);
    public void updatePrice(int id,int newp);
    public void deleteBook(int id);
    public void deleteAuthor(int aid);
}
