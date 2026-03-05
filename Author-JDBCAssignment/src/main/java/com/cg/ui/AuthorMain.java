package com.cg.ui;

import com.cg.bean.Author;
import com.cg.bean.Book;
import com.cg.service.AuthorService;
import com.cg.service.BookService;
import com.cg.service.IAuthorService;
import com.cg.service.IBookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthorMain {
    public static void main(String[] args) {
        IAuthorService auth = new AuthorService();
        IBookService bookservice = new BookService();

        //create author & book
        Author a = new Author(2302,"James","","Gosling","9829319933");
        System.out.println(auth.createAuthor(a));

        Book b = new Book(49861,"Java Programming",345.00,2301);
        System.out.println(bookservice.createBook(b));
//        //read
        Author a1 = auth.findAuthor(2301);
        System.out.println(a1.getAuthorId()+"\t"+a1.getFirstName()+"\t"+a1.getMiddleName()+"\t"+a1.getLastName()+"\t"+a1.getPhoneNo());
        //update
        Author a2 = new Author(2301,"","Arthur","","");
        auth.updateAuthor(a2);
        //delete
        System.out.println(auth.deleteAuthor(2302));
        //get list of Books of a specific author
        List<Book> book_list;
        book_list = bookservice.booklist(2301);
        for(Book book:book_list){
            System.out.println(book.getISBN()+"\t"+book.getTitle()+book.getPrice()+"\t"+book.getAuthorId());
        }
    }
}
