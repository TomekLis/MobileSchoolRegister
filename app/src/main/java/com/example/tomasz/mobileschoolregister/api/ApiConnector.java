package com.example.tomasz.mobileschoolregister.api;

import com.example.tomasz.mobileschoolregister.helper.Token;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tomasz on 24-Dec-17.
 */

public class ApiConnector {

    private static final String baseUrl = "http://192.168.55.108/";
    private static final ApiConnector apiConnectorInstance = new ApiConnector();

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    private static Retrofit retrofit = builder.build();





    private ApiConnector(){}

    public static ApiConnector getInstance(){
        return apiConnectorInstance;
    }

    public static <T>T createClient(final Class<T> service){
        return retrofit.create(service);
    }

    public static <T>T createAuthrizedClient (final Class<T> service, final Token token){

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                        "Bearer " + token.getAccessToken());

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();

         Retrofit authorizedRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                 .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                 .build();

        return authorizedRetrofit.create(service);
    }

}
