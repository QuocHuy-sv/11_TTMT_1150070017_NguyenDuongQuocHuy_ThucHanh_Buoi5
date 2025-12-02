package com.example.nguyenduongquochuylab.net;

import com.example.nguyenduongquochuylab.net.dto.LoginRequest;
import com.example.nguyenduongquochuylab.net.dto.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("auth/login")
    Call<LoginResponse> login(@Body LoginRequest body);

}
