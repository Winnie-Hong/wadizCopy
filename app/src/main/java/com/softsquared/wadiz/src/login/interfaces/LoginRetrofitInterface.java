package com.softsquared.wadiz.src.login.interfaces;

import com.softsquared.wadiz.src.login.models.LoginResponse;
import com.softsquared.wadiz.src.main.models.DefaultResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LoginRetrofitInterface {

    @FormUrlEncoded
    @POST("/signin")
    Call<LoginResponse> postSignIn(@Field("email") String email, @Field("pw") String pw);
}
