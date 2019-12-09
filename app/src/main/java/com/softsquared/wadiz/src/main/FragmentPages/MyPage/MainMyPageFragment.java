package com.softsquared.wadiz.src.main.FragmentPages.MyPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.login.LoginActivity;

public class MainMyPageFragment extends Fragment {

    TextView textViewLogin;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.fragment_main_mypage, container, false);

        textViewLogin = view.findViewById(R.id.mypage_btn_login);

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;

    }
}
