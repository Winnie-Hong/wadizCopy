package com.softsquared.wadiz.src.login.interfaces;

import com.softsquared.wadiz.src.login.models.LoginResponse;

import java.util.ArrayList;

public interface LoginActivityView {

    void validateFailure(String message);

    void postSignInSuccess(String result,String jwt);
}
