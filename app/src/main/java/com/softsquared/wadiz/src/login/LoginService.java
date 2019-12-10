package com.softsquared.wadiz.src.login;

import android.util.Log;

import com.softsquared.wadiz.src.login.interfaces.LoginActivityView;
import com.softsquared.wadiz.src.login.interfaces.LoginRetrofitInterface;
import com.softsquared.wadiz.src.login.models.LoginResponse;
import com.softsquared.wadiz.src.main.interfaces.MainActivityView;
import com.softsquared.wadiz.src.main.interfaces.MainRetrofitInterface;
import com.softsquared.wadiz.src.main.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class LoginService {
    private final LoginActivityView mLoginActivityVIew;

    LoginService(final LoginActivityView loginActivityView) {
        this.mLoginActivityVIew = loginActivityView;
    }


    void postSignIn(final String email, final String pw) {
        final LoginRetrofitInterface loginRetrofitInterface = getRetrofit().create(LoginRetrofitInterface.class);
        loginRetrofitInterface.postSignIn(email, pw).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                final LoginResponse loginResponse = response.body();
                if (loginResponse == null) {
                    mLoginActivityVIew.validateFailure(null);

                    return;
                }else if(loginResponse.getCode() == 200){
                    mLoginActivityVIew.postSignInSuccess(loginResponse.getMessage(),loginResponse.getResult());
//System.out.println(loginResponse.getResult());
                    return;
                }
                mLoginActivityVIew.validateFailure(loginResponse.getMessage());
            }


            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                mLoginActivityVIew.validateFailure(null);
            }
        });
    }
}
