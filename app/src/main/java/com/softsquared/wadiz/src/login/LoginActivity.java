package com.softsquared.wadiz.src.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.signUp.SignUpActivity;
import com.softsquared.wadiz.src.login.interfaces.LoginActivityView;
import com.softsquared.wadiz.src.login.models.LoginResponse;
import com.softsquared.wadiz.src.main.MainActivity;

import java.util.ArrayList;

import static com.softsquared.wadiz.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.wadiz.src.ApplicationClass.sSharedPreferences;

public class LoginActivity extends BaseActivity implements LoginActivityView{

    private ArrayList<LoginResponse> mLoginResponses;
    TextView validation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final EditText editTextEmail;
        final EditText editTextPw;
        TextView loginButton;
        TextView signUpButton;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.activity_login_et_ID);
        editTextPw = findViewById(R.id.activity_login_et_password);
        loginButton = findViewById(R.id.activity_login_btn_login);
        validation = findViewById(R.id.activity_login_tv_validation);
        signUpButton = findViewById(R.id.activity_login_btn_sign_up);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = editTextEmail.getText().toString();
                final String pw = editTextPw.getText().toString();
                postSignIn(email, pw);

            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

    private void postSignIn(String email, String pw) {
        showProgressDialog();
        final LoginService loginService = new LoginService((LoginActivityView) this);
        loginService.postSignIn(email, pw);
    }

    public void validateFailure(String message) {
        hideProgressDialog();
        validation.setText(message);
        validation.setVisibility(View.VISIBLE);
    }

    @Override
    public void postSignInSuccess(String result,String jwt) {
        hideProgressDialog();

        SharedPreferences.Editor editor = sSharedPreferences.edit();
        editor.putString(X_ACCESS_TOKEN, jwt); // key, value를 이용하여 저장하는 형태
        editor.apply();

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
