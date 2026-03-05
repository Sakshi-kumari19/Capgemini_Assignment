package com.cg.dao;

import com.cg.bean.Book;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao implements IBookDao{
    private static Connection con;
    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/author","root","Sk@24sql");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String createBook(Book b){
        try {
            PreparedStatement ps = con.prepareStatement("insert into book values(?,?,?,?)");
            ps.setInt(1,b.getISBN());
            ps.setString(2,b.getTitle());
            ps.setDouble(3,b.getPrice());
            ps.setInt(4,b.getAuthorId());
            if(ps.executeUpdate()>0)
                return "Book data created";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Book Data not created";
    }

    @Override
    public List<Book> booklist(Integer id){
        List<Book> books = new ArrayList<Book>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from book where authorId=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                books.add(new Book(rs.getInt(1),rs.getString("title"),rs.getDouble("price"),rs.getInt("authorId")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public String deleteBook(Integer id){
        try {
            PreparedStatement ps = con.prepareStatement("delete from book where auhtorId=?");
            ps.setInt(1,id);
            if(ps.executeUpdate()>0)
                return "Data deleted";

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Data not deleted";
    }
}
