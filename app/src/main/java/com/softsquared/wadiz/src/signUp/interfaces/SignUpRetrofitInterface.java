package com.softsquared.wadiz.src.signUp.interfaces;

import com.softsquared.wadiz.src.login.models.LoginResponse;
import com.softsquared.wadiz.src.signUp.models.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SignUpRetrofitInterface {

    @FormUrlEncoded
    @POST("/signup")
    Call<SignUpResponse> postSignUp(@Field("email") String email, @Field("name") String name, @Field("pw") String pw, @Field("repw") String repw);
}
