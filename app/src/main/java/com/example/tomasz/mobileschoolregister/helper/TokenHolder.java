package com.example.tomasz.mobileschoolregister.helper;

import android.app.Activity;
import android.content.Intent;

import com.example.tomasz.mobileschoolregister.LoginActivity;

/**
 * Created by Tomasz on 20-Jan-18.
 */

public class TokenHolder {
    private Token securityToken;

    public Token getSecurityToken(){
        return securityToken;
    }

    public void setToken(Token token){
        securityToken = token;
    }
    private static final TokenHolder tokenHolder = new TokenHolder();

    public static TokenHolder getInstance(){
        return tokenHolder;}


}
