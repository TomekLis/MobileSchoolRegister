package com.example.tomasz.mobileschoolregister.helper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Tomasz on 22-Dec-17.
 */

public class Token implements Serializable {

    @SerializedName("access_token")
    @Expose()
    private String accessToken;

    @SerializedName("token_type")
    @Expose()
    private String tokenType;

    @SerializedName("expires_in")
    @Expose()
    private int expiresIn;

    @SerializedName("userId")
    @Expose()
    private String userId;

    @SerializedName(".issued")
    @Expose()
    private String issued;

    @SerializedName(".expires")
    @Expose()
    private String expires;


    @SerializedName("type")
    @Expose()
    private String type;

    public Token(String accessToken, String tokenType, int expiresIn, String userId, String issued, String expires, String type) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.userId = userId;
        this.issued = issued;
        this.expires = expires;
        this.type = type;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}