package com.cg.service;

import com.cg.bean.Book;
import com.cg.dao.BookDao;
import com.cg.dao.IBookDao;

import java.util.List;

public class BookService implements IBookService{
    IBookDao bdao = new BookDao();
    @Override
    public String createBook(Book b){
           if(b.getISBN()==null || b.getPrice()==null || b.getTitle()==null){
               return "Book not created";
           }
           return bdao.createBook(b);
    }

    @Override
    public List<Book> booklist(Integer id){
           if(id==null)
               return null;
           else
               return bdao.booklist(id);
    }
    @Override
    public String deleteBook(Integer id){
        if(id==null) return "Invalid id";
        else
            return bdao.deleteBook(id);
    }
}
