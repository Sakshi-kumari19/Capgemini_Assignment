package com.cg.dao;

import com.cg.bean.Author;

public interface IAuthorDao {
    public String insertAuthor(Author a);
    public Author readAuthor(Integer aid);
    public String updateAuthor(Author a);
    public String deleteAuthor(Integer aid);
}
