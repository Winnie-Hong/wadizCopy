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

    int projectIdx;
    String remainingDays;
    private Context mContext;

    private TabLayout mProjectTablayout;

    private ViewPager mProjectDetailsViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_project_details);
        mContext = getApplicationContext();

        //탭 이름 설정
        mProjectTablayout = findViewById(R.id.project_details_tab_bar);

        ProjectDetailsAdapter projectDetailsAdapter = new ProjectDetailsAdapter(getSupportFragmentManager());
        mProjectDetailsViewPager = findViewById(R.id.project_details_view_pager);
        mProjectDetailsViewPager.setAdapter(new ProjectDetailsAdapter(getSupportFragmentManager()));

        mProjectTablayout.setupWithViewPager(mProjectDetailsViewPager);

    }



}
