package com.example.oblig.Entity;

public class LoginRequest {
    private String name;

    private String password;



    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginRequest(String pName , String pPassword){
        this.name = pName;
        this.password = pPassword;
    }

    public LoginRequest(){
        
    }

}
