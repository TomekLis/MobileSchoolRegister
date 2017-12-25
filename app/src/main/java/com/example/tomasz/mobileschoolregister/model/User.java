package com.example.tomasz.mobileschoolregister.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tomasz on 22-Dec-17.
 */

public class User {

    @SerializedName("Id")
    @Expose()
    private String id;
    @SerializedName("UserName")
    @Expose()
    private String userName;
    @SerializedName("FullName")
    @Expose()
    private String fullName;
    @SerializedName("FirstName")
    @Expose()
    private String firstName;
    @SerializedName("LastName")
    @Expose()
    private String lastName;
    @SerializedName("Email")
    @Expose()
    private String email;
    @SerializedName("PhoneNumber")
    @Expose()
    private String phoneNumber;

    public User(String id, String userName, String fullName, String firstName, String lastName, String email, String phoneNumber) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
