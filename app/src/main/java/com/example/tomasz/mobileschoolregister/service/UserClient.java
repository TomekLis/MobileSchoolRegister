package com.example.tomasz.mobileschoolregister.service;

/**
 * Created by Tomasz on 22-Dec-17.
 */

public class UserClient {
    String grantType;
    String userName;

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String password;

    public UserClient(String userName, String password) {
        this.grantType = "password";
        this.userName = userName;
        this.password = password;
    }
}
