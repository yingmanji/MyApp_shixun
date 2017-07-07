package com.example.a0_0.myapp_shixun.sqlite.model;

/**
 * Created by 樱满集0_0 on 2017/6/25.
 */

public class User {
    private int userId;
    private String userName;
    private String userPassword;

    public User(){

    }
    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "user:["+userName+","+userPassword+"]";
    }
}
