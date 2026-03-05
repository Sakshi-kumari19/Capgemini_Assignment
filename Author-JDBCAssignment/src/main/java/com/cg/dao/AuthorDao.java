package com.cg.dao;

import com.cg.bean.Author;

import java.sql.*;

public class AuthorDao implements IAuthorDao{
    private static Connection con;
    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/author","root","Sk@24sql");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String insertAuthor(Author a){
        try {
            PreparedStatement ps =con.prepareStatement("insert into author values(?,?,?,?,?)");
            ps.setInt(1,a.getAuthorId());
            ps.setString(2,a.getFirstName());
            ps.setString(3,a.getMiddleName());
            ps.setString(4,a.getLastName());
            ps.setString(5,a.getPhoneNo());
            int row = ps.executeUpdate();
            if(row>0) return "Author created";

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Not created";


    }
    @Override
    public Author readAuthor(Integer aid){
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("select * from author where id=?");
            ps.setInt(1,aid);
            ResultSet r = ps.executeQuery();
            r.next();
            Author a = new Author(
                    r.getInt("id"),
                    r.getString("first_name"),
                    r.getString("middle_name"),
                    r.getString("last_name"),
                    r.getString("phone_no")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    @Override
    public String updateAuthor(Author a){
        PreparedStatement ps;

            if(!a.getMiddleName().isEmpty()) {
                try {
                    ps = con.prepareStatement("update author set middle_name=? where id=?");
                    ps.setString(1,a.getMiddleName());
                    ps.setInt(2,a.getAuthorId());
                    if(ps.executeUpdate()>0)
                        return "Data updated...";


                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            return "Data not updated";

    }
    @Override
    public String deleteAuthor(Integer aid){
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("delete from author where id=?");
            ps.setInt(1,aid);
            int r = ps.executeUpdate();

            if(r>0) return "Data deleted";
            else return "Data not Deleted";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
