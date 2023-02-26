/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storymaker.view;

/**
 *
 * @author sauru
 */
public class User {

    private int id;
    private boolean isLogin;
    private String username;
    private String password;
    private String email;

    public User() {
        this.id = 0;
        this.username = "";
        this.password = "";
        this.email = "";
        this.isLogin = false;
    }

    public User(String username, String password, String email) {
        this.id = 0;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isLogin = false;

    }

    public User(String username, String password) {
        this.id = 0;
        this.username = username;
        this.password = password;
        this.email = "";
        this.isLogin = false;

    }

    public User(int id, String username, boolean isLogin) {
        this.id = id;
        this.username = username;
        this.password = "";
        this.email = "";
        this.isLogin = isLogin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsLogin() {
        return this.isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void checkLogin(){
        
    }

}
