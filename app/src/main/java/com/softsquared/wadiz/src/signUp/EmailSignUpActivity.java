package com.softsquared.wadiz.src.signUp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.login.LoginActivity;
import com.softsquared.wadiz.src.login.interfaces.LoginActivityView;
import com.softsquared.wadiz.src.main.MainActivity;
import com.softsquared.wadiz.src.signUp.interfaces.SignUpActivityView;

import org.w3c.dom.Text;

public class EmailSignUpActivity extends BaseActivity implements SignUpActivityView {

    TextView mInvalidatePasswordMessage;
    boolean agreeValidate, emailValidate, nameValidate, passwordValidate, rePasswordValidate;
    CheckBox mCheckBoxAgreeTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_sign_up);

        final EditText editTextEmail;
        final Button validateEmail;
        final TextView invalidateEmailMessage;
        final EditText editTextName;
        final EditText editTextPassword;
        final EditText editTextRePassword;
        final TextView buttonDone;

        editTextEmail = findViewById(R.id.sign_up_email_validate);
        validateEmail = findViewById(R.id.sign_up_btn_validate_email);
        invalidateEmailMessage = findViewById(R.id.sign_up_invalidate_email_message);
        editTextName = findViewById(R.id.activity_sign_up_name);
        editTextPassword = findViewById(R.id.activity_sign_up_pw);
        editTextRePassword = findViewById(R.id.activity_sign_up_re_pw);
        buttonDone = findViewById(R.id.activity_sign_up_done);
        mInvalidatePasswordMessage = findViewById(R.id.sign_up_invalidate_message);

        //약관 동의버튼
        mCheckBoxAgreeTerms = findViewById(R.id.sign_up_agree_checkbox);
        mCheckBoxAgreeTerms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    validateEmail.setClickable(true);
                    validateEmail.setBackground(getDrawable(R.drawable.sign_up_validate_btn));
                } else {
                    validateEmail.setClickable(false);
                    validateEmail.setBackground(getDrawable(R.drawable.sign_up_invalidate_btn));
                    invalidateEmailMessage.setVisibility(View.GONE);
                }
            }
        });

        //이메일 버튼 활성화
        validateEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextEmail.getText().toString().length() >= 1){
                    invalidateEmailMessage.setText("인증되었습니다.");
                    invalidateEmailMessage.setVisibility(View.VISIBLE);
                }

            }
        });

        //이메일 리스너
        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (editTextEmail.getText().toString().length() >=5) {
                    emailValidate = true;
                } else {
                    emailValidate = false;
                    invalidateEmailMessage.setText("이메일을 인증해주세요.");
                }
                if(isAllChecked()){
                    buttonDone.setBackgroundColor(getResources().getColor(R.color.mainColor));
                    buttonDone.setClickable(true);
                }else {
                    buttonDone.setBackgroundColor(Color.parseColor("#8000C4C4"));
                    buttonDone.setClickable(false);
                }
            }
        });

        //이름 리스너
        editTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editTextName.getText().toString().length() >= 2) {
                    nameValidate = true;
                } else {
                    nameValidate = false;
                }
                if(isAllChecked()){
                    buttonDone.setBackgroundColor(getResources().getColor(R.color.mainColor));
                    buttonDone.setClickable(true);
                }else {
                    buttonDone.setBackgroundColor(Color.parseColor("#8000C4C4"));
                    buttonDone.setClickable(false);
                }
            }
        });

        //비밀번호 리스너
        editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editTextPassword.getText().toString().length() >= 8) {
                    passwordValidate = true;
                } else {
                    passwordValidate = false;
                }
                if(isAllChecked()){
                    buttonDone.setBackgroundColor(getResources().getColor(R.color.mainColor));
                    buttonDone.setClickable(true);
                }else {
                    buttonDone.setBackgroundColor(Color.parseColor("#8000C4C4"));
                    buttonDone.setClickable(false);
                }
            }
        });

        //비밀번호 재입력 리스너
        editTextRePassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editTextRePassword.getText().toString().length() >= 8) {
                    rePasswordValidate = true;
                } else {
                    rePasswordValidate = false;
                }
                if(isAllChecked()){
                    buttonDone.setBackgroundColor(getResources().getColor(R.color.mainColor));
                    buttonDone.setClickable(true);
                } else {
                    buttonDone.setBackgroundColor(Color.parseColor("#8000C4C4"));
                    buttonDone.setClickable(false);
                }
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

    //모든 항목 작성했는지 확인
    private boolean isAllChecked() {
        return (nameValidate && emailValidate && mCheckBoxAgreeTerms.isChecked() && passwordValidate && rePasswordValidate);
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
