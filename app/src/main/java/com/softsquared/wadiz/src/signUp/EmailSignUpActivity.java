package com.softsquared.wadiz.src.signUp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.login.LoginActivity;
import com.softsquared.wadiz.src.login.interfaces.LoginActivityView;
import com.softsquared.wadiz.src.main.MainActivity;
import com.softsquared.wadiz.src.signUp.interfaces.SignUpActivityView;

public class EmailSignUpActivity extends BaseActivity implements SignUpActivityView {

    TextView mInvalidatePasswordMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_sign_up);

        boolean agreeIsChecked;
        final EditText editTextEmail;
        final Button validateEmail;
        final TextView invalidateEmailMessage;
        final EditText editTextName;
        final EditText editTextPassword;
        final EditText editTextRePassword;
        TextView buttonDone;

        editTextEmail = findViewById(R.id.sign_up_email_validate);
        validateEmail = findViewById(R.id.sign_up_btn_validate_email);
        invalidateEmailMessage = findViewById(R.id.sign_up_invalidate_email_message);
        editTextName = findViewById(R.id.activity_sign_up_name);
        editTextPassword = findViewById(R.id.activity_sign_up_pw);
        editTextRePassword = findViewById(R.id.activity_sign_up_re_pw);
        buttonDone = findViewById(R.id.activity_sign_up_done);
        mInvalidatePasswordMessage = findViewById(R.id.sign_up_invalidate_message);

        //약관 동의버튼
        final CheckBox checkBoxAgreeTerms = findViewById(R.id.sign_up_agree_checkbox);
        checkBoxAgreeTerms.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (checkBoxAgreeTerms.isChecked()){
                    validateEmail.isClickable();
                    validateEmail.setBackground(getDrawable(R.drawable.sign_up_validate_btn));
                    return;
                }
                else {
                    validateEmail.setClickable(false);
                    validateEmail.setBackground(getDrawable(R.drawable.sign_up_invalidate_btn));
                    return;
                }
            }
        });

        //이메일 버튼 활성화
        validateEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invalidateEmailMessage.setText("인증되었습니다.");
                invalidateEmailMessage.setVisibility(View.VISIBLE);
            }
        });

//완료 버튼 클릭 이벤트
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = editTextEmail.getText().toString();
                String name = editTextName.getText().toString();
                String pw = editTextPassword.getText().toString();
                String repw = editTextRePassword.getText().toString();
                postSignUp(Email, name, pw, repw);
            }
        });

    }

    private void postSignUp(String email, String name, String pw, String repw) {
        showProgressDialog();
        final SignUpService signUpService = new SignUpService(this);
        signUpService.postSignUp(email, name, pw, repw);
    }

    public void validateFailure(String message) {
        hideProgressDialog();
        mInvalidatePasswordMessage.setText(message);
        mInvalidatePasswordMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void postSignUpSuccess(String message) {
        hideProgressDialog();
//        Log.d("tag", "success");
        showCustomToast("회원가입 성공");
        Intent intent = new Intent(EmailSignUpActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
