package com.softsquared.wadiz.src.projectDetails.fragmentPages.story;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.interfaces.StoryFragmentView;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.models.ProjectStoryData;

public class StoryFragment extends BaseFragment implements StoryFragmentView {

    int projectIdx;
    String remainingDays;

    private TabLayout mProjectTablayout;

    private TextView mBarTitle;
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
    //    private WebView mWebView;
    private RoadView mWebView;
    private WebSettings mWebSettings;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        {
            final View view = inflater.inflate(R.layout.fragment_project_details_story, container, false);

            mBarTitle = view.findViewById(R.id.project_details_bar_title);
            mThumbnail = view.findViewById(R.id.project_details_thumbnail);
            mTitle = view.findViewById(R.id.project_details_title);
            mCategory = view.findViewById(R.id.project_details_category);
            mInfoText = view.findViewById(R.id.project_details_info_text);
            mWebView = view.findViewById(R.id.wv_detail);
            mRemaining = view.findViewById(R.id.project_details_remaining);
            mSupporterCnt = view.findViewById(R.id.project_details_supporter_cnt);

            //웹뷰
            mWebView.setWebViewClient(new WebViewClient()); // 클릭시 새창 안뜨게
            mWebView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
            mWebSettings = mWebView.getSettings(); //세부 세팅 등록
            mWebSettings.setJavaScriptEnabled(true); // 웹페이지 자바스크립트 허용 여부
            mWebSettings.setSupportMultipleWindows(false); // 새창 띄우기 허용 여부
            mWebSettings.setJavaScriptCanOpenWindowsAutomatically(false); // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부
            mWebSettings.setLoadWithOverviewMode(true); // 메타태그 허용 여부
            mWebSettings.setUseWideViewPort(true); // 화면 사이즈 맞추기 허용 여부
            mWebSettings.setSupportZoom(false); // 화면 줌 허용 여부??
            mWebSettings.setBuiltInZoomControls(false); // 화면 확대 축소 허용 여부
            mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING); // 컨텐츠 사이즈 맞추기
            mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 브라우저 캐시 허용 여부
            mWebSettings.setDomStorageEnabled(true); // 로컬저장소 허용 여부
            mWebView.setOverScrollMode(View.OVER_SCROLL_NEVER);
            mWebView.setNestedScrollingEnabled(false);


            Intent intent = getActivity().getIntent();
            projectIdx = intent.getExtras().getInt("projectIdx");
            remainingDays = intent.getExtras().getString("remaining");
            getProjectDetails(projectIdx);
            Log.d("projectIdx", projectIdx + "");

            return view;
        }

    }

    @Override
    public void validateFailure(String message) {
        hideProgressDialog();
//        showCustomToast(getActivity(), message);
    }

    private void getProjectDetails(int projectIdx) {
        showProgressDialog(getActivity());
        final StoryService storyService = new StoryService(this);
        storyService.getProjectDetails(projectIdx);
    }


    @Override
    public void getProjectDetailsSuccess(ProjectStoryData projectStoryData) {
        hideProgressDialog();

        Glide.with(this).load(projectStoryData.getThumbnail()).centerCrop().into(mThumbnail);
        mTitle.setText(projectStoryData.getTitle());
        mCategory.setText(projectStoryData.getCategory());
        mInfoText.setText(projectStoryData.getInfoText());

        mSupporterCnt.setText(projectStoryData.getSupporterCnt());
        mRemaining.setText(remainingDays);

        mWebView.loadData(projectStoryData.getProjectStory(), "text/html; charset=UTF-8", null);

    }

}
