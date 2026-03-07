package com.cg.dao;

import com.cg.bean.Author;
import com.cg.bean.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LibraryManagement implements ILibraryManagement{

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
    static EntityManager em = emf.createEntityManager();

    @Override
    public void createAuthor(Author a){
           em.getTransaction().begin();
           em.persist(a);
           em.getTransaction().commit();

    }
    @Override
    public void readAuthor(int aid){
           em.getTransaction().begin();
           Author a = em.find(Author.class,aid);
           em.getTransaction().commit();
           System.out.println("Author: ");
           System.out.println("Author Id: "+a.getAuthor_id());
           System.out.println("Name: "+a.getAuthor_name());
           System.out.println("Email: "+a.getEmail());

          System.out.println("Book Written: ");
          for(Book b:a.getBooks()){
              System.out.println("Books: "+b.getTitle()+" | "+"Price: "+b.getPrice());
          }


    }
    @Override
    public void updatePrice(int id,int newp){
          em.getTransaction().begin();
          Book b = em.find(Book.class,id);
          b.setPrice(newp);
          em.getTransaction().commit();

    }
    @Override
    public void deleteBook(int id){
          em.getTransaction().begin();
          Book b = em.find(Book.class,id);
          em.remove(b);
          em.getTransaction().commit();
    }

    @Override
    public void deleteAuthor(int aid){
           em.getTransaction().begin();
           Author a = em.find(Author.class,aid);
           em.remove(a);
           em.getTransaction().commit();
    }

}
