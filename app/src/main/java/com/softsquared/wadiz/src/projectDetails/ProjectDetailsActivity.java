package com.softsquared.wadiz.src.projectDetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.login.LoginActivity;
import com.softsquared.wadiz.src.projectDetails.rewardPolicy.FundPolicyActivity;

import static com.softsquared.wadiz.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.wadiz.src.ApplicationClass.sSharedPreferences;

public class ProjectDetailsActivity extends BaseActivity{

    Button mFundBtn;
    int mProjectIdx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_project_details);
        Context mContext = getApplicationContext();
        TextView mProjectTitle = findViewById(R.id.project_details_bar_title);
        mFundBtn = findViewById(R.id.btn_fund);

        //어댑터 뷰페이저 설정
        TabLayout mProjectTablayout = findViewById(R.id.project_details_tab_bar);

//        ProjectDetailsAdapter projectDetailsAdapter = new ProjectDetailsAdapter(getSupportFragmentManager());
        ViewPager mProjectDetailsViewPager = findViewById(R.id.project_details_view_pager);
        mProjectDetailsViewPager.setAdapter(new ProjectDetailsAdapter(getSupportFragmentManager()));

        mProjectTablayout.setupWithViewPager(mProjectDetailsViewPager);

        //프로젝트 제목 설정
        Intent intent = getIntent();
        mProjectTitle.setText(intent.getExtras().getString("projectTitle"));
        mProjectIdx  = intent.getExtras().getInt("projectIdx");

        //뒤로가기 버튼
        ImageView mGoBackButton = findViewById(R.id.project_details_icon_go_back);
        mGoBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //펀딩하기 버튼
        mFundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String jwtToken = sSharedPreferences.getString(X_ACCESS_TOKEN, null);
                if (jwtToken == null){
                    showCustomToast("로그인 해주세요.");
                    Intent loginIntent = new Intent(ProjectDetailsActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                }
                else {
                    Intent fundIntent = new Intent(ProjectDetailsActivity.this, FundPolicyActivity.class);
                    fundIntent.putExtra("projectIdx", mProjectIdx);
                    startActivity(fundIntent);
                }
            }
        });

    }



}
