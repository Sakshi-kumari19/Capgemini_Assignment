package com.cg.service;

import com.cg.bean.Author;
import com.cg.dao.AuthorDao;
import com.cg.dao.BookDao;
import com.cg.dao.IAuthorDao;
import com.cg.dao.IBookDao;

public class AuthorService implements IAuthorService{
    IAuthorDao ad = new AuthorDao();
    IBookDao bdao = new BookDao();
    @Override
    public String createAuthor(Author a){
           if(a.getAuthorId()==null || a.getFirstName()==null || a.getPhoneNo()==null){
               return "Author not created";
           }else{
               return ad.insertAuthor(a);
           }
    }
    @Override
    public Author findAuthor(Integer id){
           if(id==null){
               System.out.println("Invalid id");
               return null;
           }else{
               return ad.readAuthor(id);
           }
    }
    @Override
    public String updateAuthor(Author a){

        return ad.updateAuthor(a);
    }
    @Override
    public String deleteAuthor(Integer id){
           bdao.deleteBook(id);
           return ad.deleteAuthor(id);
    }
}