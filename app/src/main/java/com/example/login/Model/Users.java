package com.example.login.Model;

public class Users {
    private int id;
    private String name;
    private String email;
    private String pass;

    public Users(String name,String email){
        this.email=email;
        this.name=name;
    }

    public Users(int id,String name,String email,String pass){
        this.id=id;
        this.email=email;
        this.name=name;
        this.pass=pass;
    }

    public Users() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
