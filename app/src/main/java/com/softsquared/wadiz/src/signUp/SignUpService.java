package com.softsquared.wadiz.src.signUp;

import android.util.Log;


import com.softsquared.wadiz.src.signUp.interfaces.SignUpActivityView;
import com.softsquared.wadiz.src.signUp.interfaces.SignUpRetrofitInterface;
import com.softsquared.wadiz.src.signUp.models.SignUpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class SignUpService {
    private final SignUpActivityView mSignUpActivityView;

    SignUpService(final SignUpActivityView signUpActivityView) {
        this.mSignUpActivityView = signUpActivityView;
    }


    void postSignUp(final String email, final String name, String pw, String repw) {
        final SignUpRetrofitInterface signUpRetrofitInterface = getRetrofit().create(SignUpRetrofitInterface.class);
        signUpRetrofitInterface.postSignUp(email, name, pw, repw).enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                final SignUpResponse signUpResponse = response.body();
                if (signUpResponse == null) {
                    mSignUpActivityView.validateFailure(null);
                    return;
                }else if(signUpResponse.getCode() == 201){
                    mSignUpActivityView.postSignUpSuccess(signUpResponse.getMessage());
                    return;
                }
                mSignUpActivityView.validateFailure(signUpResponse.getMessage());
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                mSignUpActivityView.validateFailure(null);
            }
        });
    }
}
