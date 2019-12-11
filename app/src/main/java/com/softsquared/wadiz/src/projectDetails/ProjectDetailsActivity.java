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
import android.widget.ImageView;
import android.widget.TextView;


import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;

public class ProjectDetailsActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_project_details);
        Context mContext = getApplicationContext();
        TextView mProjectTitle = findViewById(R.id.project_details_bar_title);

        //어댑터 뷰페이저 설정
        TabLayout mProjectTablayout = findViewById(R.id.project_details_tab_bar);

//        ProjectDetailsAdapter projectDetailsAdapter = new ProjectDetailsAdapter(getSupportFragmentManager());
        ViewPager mProjectDetailsViewPager = findViewById(R.id.project_details_view_pager);
        mProjectDetailsViewPager.setAdapter(new ProjectDetailsAdapter(getSupportFragmentManager()));

        mProjectTablayout.setupWithViewPager(mProjectDetailsViewPager);

        //프로젝트 제목 설정
        Intent intent = getIntent();
        mProjectTitle.setText(intent.getExtras().getString("projectTitle"));

        //뒤로가기 버튼
        ImageView mGoBackButton = findViewById(R.id.project_details_icon_go_back);
        mGoBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }



}
