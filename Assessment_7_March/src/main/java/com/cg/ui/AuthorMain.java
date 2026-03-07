package com.cg.ui;

import com.cg.bean.Author;
import com.cg.bean.Book;
import com.cg.dao.ILibraryManagement;
import com.cg.dao.LibraryManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthorMain {
    public static void main(String[] args) {

        int choice,id;
        Scanner sc = new Scanner(System.in);
        ILibraryManagement lm = new LibraryManagement();
        Author a;
        List<Book> books = new ArrayList<>();
        while (true) {
            System.out.println("Library Management System");
            System.out.println("1.Create Operation");
            System.out.println("2.Read Operation");
            System.out.println("3.Update Operation");
            System.out.println("4.Delete Book");
            System.out.println("5.Delete Author");
            System.out.println("6.Exit");

            System.out.println("Enter you choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:{
                    System.out.println("Author: ");
                    System.out.println("Author Id: ");
                    id = sc.nextInt();
                    System.out.println("Name : ");
                    String name = sc.next();

                    System.out.println("Email: ");
                    String email = sc.next();

                    a = new Author(id,name,email);

                    System.out.println("Books: ");
                    for(int i=1;i<=3;i++){
                        System.out.println("Book"+i+": ");
                        sc.nextLine();
                        String title = sc.nextLine();
                        System.out.println("Price"+i+": ");
                        int price = sc.nextInt();
                        books.add(new Book(title,price));
                    }
                    a.setBooks(books);
                    lm.createAuthor(a);
                    break;
                }
                case 2:{
                    System.out.println("Enter Author Id: ");
                    id = sc.nextInt();
                    lm.readAuthor(id);
                    break;
                }
                case 3:{
                    System.out.println("Enter Book Id: ");
                    id = sc.nextInt();
                    System.out.println("Enter New price: ");
                    int price = sc.nextInt();
                    lm.updatePrice(id,price);
                    break;
                }
                case 4:{
                    System.out.println("Enter Book Id: ");
                    id = sc.nextInt();
                    lm.deleteBook(id);
                    break;
                }
                case 5:{
                    System.out.println("Enter Author Id: ");
                    id = sc.nextInt();
                    lm.deleteAuthor(id);
                    break;
                }
                case 6:
                    return;


            }


        }
    }
}
