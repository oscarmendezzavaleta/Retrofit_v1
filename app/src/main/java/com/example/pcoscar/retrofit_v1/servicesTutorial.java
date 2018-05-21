package com.example.pcoscar.retrofit_v1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface servicesTutorial {

    @GET("usersFake")
    Call<List<ResponSeservice>> getUsersGet();

    @POST("usersFake")
    Call<List<ResponSeservice>>getUsersPost();

}
