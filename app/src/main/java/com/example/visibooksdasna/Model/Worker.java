package com.example.visibooksdasna.Model;

public class Worker {
    private int id;
    private String name, phoneno, dateofbirth, email, address, post;

    public Worker(int id, String name, String phoneno, String dateofbirth, String email, String address, String post) {
        this.id = id;
        this.name = name;
        this.phoneno = phoneno;
        this.dateofbirth = dateofbirth;
        this.email = email;
        this.address = address;
        this.post = post;
    }

    public Worker() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
