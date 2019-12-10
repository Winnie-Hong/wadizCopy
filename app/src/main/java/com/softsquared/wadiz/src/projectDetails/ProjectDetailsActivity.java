package com.softsquared.wadiz.src.projectDetails;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.projectDetails.interfaces.ProjectDetailsActivityView;
import com.softsquared.wadiz.src.projectDetails.models.ProjectDetailsData;

import java.util.ArrayList;

public class ProjectDetailsActivity extends BaseActivity implements ProjectDetailsActivityView{

    int projectIdx;
    String remainingDays;

    private ImageView mThumbnail;
    private TextView mTitle;
    private TextView mCategory;
    private TextView mInfoText;
    private TextView mRemaining;
    private TextView mGoal;
    private TextView mTerm;
    private TextView mSupporterCnt;
    private TextView mMakerName;
    private TextView mMakerImg;
    private ImageView mFacebookBtn;
    private ImageView mInstagramBtn;
    private WebView mWebView;
    private WebSettings mWebSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_project_details);
        mThumbnail = findViewById(R.id.project_details_thumbnail);
        mTitle = findViewById(R.id.project_details_title);
        mCategory = findViewById(R.id.project_details_category);
        mInfoText = findViewById(R.id.project_details_info_text);
        mWebView = findViewById(R.id.wv_detail);
        mRemaining = findViewById(R.id.project_details_remaining);
        mSupporterCnt = findViewById(R.id.project_details_supporter_cnt);

        //웹뷰
        mWebView.setWebViewClient(new WebViewClient()); // 클릭시 새창 안뜨게
        mWebView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
        mWebSettings = mWebView.getSettings(); //세부 세팅 등록
        mWebSettings.setJavaScriptEnabled(true); // 웹페이지 자바스크립트 허용 여부
        mWebSettings.setSupportMultipleWindows(false); // 새창 띄우기 허용 여부
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(false); // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부
        mWebSettings.setLoadWithOverviewMode(true); // 메타태그 허용 여부
        mWebSettings.setUseWideViewPort(true); // 화면 사이즈 맞추기 허용 여부
        mWebSettings.setSupportZoom(false); // 화면 줌 허용 여부
        mWebSettings.setBuiltInZoomControls(false); // 화면 확대 축소 허용 여부
        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING); // 컨텐츠 사이즈 맞추기
        mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 브라우저 캐시 허용 여부
        mWebSettings.setDomStorageEnabled(true); // 로컬저장소 허용 여부

//        mWebView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return false;
//            }
//        });

        Intent intent = getIntent();
        projectIdx = intent.getExtras().getInt("projectIdx");
        remainingDays = intent.getExtras().getString("remaining");
        getProjectDetails(projectIdx);
        Log.d("projectIdx", projectIdx+"");
    }

    private void getProjectDetails(int projectIdx) {
        showProgressDialog();
        final ProjectDetailsService projectDetailsService = new ProjectDetailsService(this);
        projectDetailsService.getProjectDetails(projectIdx);
    }


    @Override
    public void validateFailure(String message) {
        hideProgressDialog();
        showCustomToast(message);
    }

    @Override
    public void getProjectDetailsSuccess(ProjectDetailsData projectDetailsData) {
        hideProgressDialog();

        Glide.with(this).load(projectDetailsData.getThumbnail()).into(mThumbnail);
        mTitle.setText(projectDetailsData.getTitle());
        mCategory.setText(projectDetailsData.getCategory());
        mInfoText.setText(projectDetailsData.getInfoText());

        mSupporterCnt.setText(projectDetailsData.getSupporterCnt());
        mRemaining.setText(remainingDays);

        mWebView.loadData(projectDetailsData.getProjectStory(), "text/html; charset=UTF-8", null);

        //나머지 친구들은 잘 가져와지나 system
//        System.out.println("상세 정보 가져오기 title : "+projectDetailsData.getTitle());//이거 하나만 확인해봐도 될 것 같아여
        //그리고 lod.d 테스트 한거 다 지워버려영



    }




}
