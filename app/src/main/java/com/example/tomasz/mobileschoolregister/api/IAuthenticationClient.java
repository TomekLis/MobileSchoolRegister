package com.example.tomasz.mobileschoolregister.api;

import com.example.tomasz.mobileschoolregister.helper.Token;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Tomasz on 22-Dec-17.
 */

public interface IAuthenticationClient {

    @FormUrlEncoded
    @POST("/MobileSchoolRegisterAppApi/token")
    Call<Token> getToken(@Field("grant_type") String grantType,
                         @Field("username") String username,
                         @Field("password") String password);


}