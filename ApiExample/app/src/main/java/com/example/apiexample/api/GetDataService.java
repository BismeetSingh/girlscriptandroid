package com.example.apiexample.api;

import com.example.apiexample.model.RetroPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetDataService {


    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();



}