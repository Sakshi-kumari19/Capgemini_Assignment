package com.cg.bean;

public class Author {

    private Integer authorId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNo;

    // Constructor
    public Author(Integer authorId, String firstName, String middleName, String lastName, String phoneNo) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
    }

    // Getters
    public Integer getAuthorId() {
        return authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    // Setters
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}