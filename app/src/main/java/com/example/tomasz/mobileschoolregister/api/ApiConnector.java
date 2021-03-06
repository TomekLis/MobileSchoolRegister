package com.example.tomasz.mobileschoolregister.api;

import com.example.tomasz.mobileschoolregister.helper.CustomStudentWithActivitiesDeserlializer;
import com.example.tomasz.mobileschoolregister.helper.CustomTeacherDeserializer;
import com.example.tomasz.mobileschoolregister.helper.Token;
import com.example.tomasz.mobileschoolregister.model.Course;
import com.example.tomasz.mobileschoolregister.model.Student;
import com.example.tomasz.mobileschoolregister.model.Teacher;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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

    private static final String baseUrl = "http://10.0.2.2/";
//    private static final String baseUrl = "http://192.168.55.108/";
    private static final ApiConnector apiConnectorInstance = new ApiConnector();

//    private static Retrofit.Builder builder = new Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
//
//    private static Retrofit retrofit = builder.build();



    private ApiConnector(){}

    public static ApiConnector getInstance(){
        return apiConnectorInstance;
    }

    public static <T>T createClient(final Class<T> service){
        OkHttpClient unauthorizedHttpClient = new OkHttpClient().newBuilder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(unauthorizedHttpClient)
                .build();
        return retrofit.create(service);
    }

    public static <T>T createAuthorizedClient(final Class<T> service, final Token token){

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

        Type studentListType = new TypeToken<List<Student>>() {}.getType();


        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Teacher.class, new CustomTeacherDeserializer())
                .registerTypeAdapter(studentListType, new CustomStudentWithActivitiesDeserlializer())
                .create();


        Retrofit authorizedRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                 .client(okHttpClient)
                 .addConverterFactory(GsonConverterFactory.create(gson))
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .build();

        return authorizedRetrofit.create(service);
    }
}
