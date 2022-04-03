package com.example.mvvm.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiinterface {


    @GET("posts")
    Call<List<postmodel>> getPosts();


}
