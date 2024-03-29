package com.softsquared.wadiz.src.main.FragmentPages.Reward.OpenSoon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.OpenSoon.interfaces.OpenSoonFragmentView;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.OpenSoon.models.OpenSoonProjectData;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.Banner;


import java.util.ArrayList;

import pl.pzienowicz.autoscrollviewpager.AutoScrollViewPager;

public class OpenSoonFragment extends BaseFragment implements OpenSoonFragmentView {

    private AutoScrollViewPager mAutoViewPager;
    private ArrayList<Banner> mBannerArrayList;
    private AutoScrollAdapter mScrollAdapter;

    private ArrayList<OpenSoonProjectData> mOpenSoonData;
    private RecyclerView mOpenSoonView;
    private OpenSoonProjectAdapter mOpenSoonProjectAdapter;
    private LinearLayoutManager mProjectLayoutManager;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opensoon, container, false);

        //배너 가져오기
        mBannerArrayList = new ArrayList<>(); //이미지 url를 저장하는 arraylist
        mAutoViewPager = view.findViewById((R.id.view_pager));
        mScrollAdapter = new AutoScrollAdapter(getActivity(), mBannerArrayList);
        mAutoViewPager.setAdapter(mScrollAdapter); //Auto Viewpager에 Adapter 장착
        mAutoViewPager.startAutoScroll(5000);

        getBanner();

        //오픈예정 둘러보기 리사이클러뷰
        mOpenSoonView = view.findViewById(R.id.recyclerview_opensoon_project);
        mOpenSoonData = new ArrayList<>();

        mProjectLayoutManager = new LinearLayoutManager(getActivity());
        mProjectLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mOpenSoonView.setLayoutManager(mProjectLayoutManager);
        mOpenSoonProjectAdapter = new OpenSoonProjectAdapter(getActivity(), mOpenSoonData);
//        showCustomToast(getActivity(), mOpenSoonData.size() + "");
        mOpenSoonView.setAdapter(mOpenSoonProjectAdapter);

        getUnopenedProject();

        return view;
    }

    private void getUnopenedProject() {
        showProgressDialog(getActivity());
        final OpenSoonService openSoonService = new OpenSoonService(this);
        openSoonService.getUnopenedProject();
    }

    private void getBanner() {
        showProgressDialog(getActivity());
        final OpenSoonService openSoonService = new OpenSoonService(this);
        openSoonService.getBanner();
    }


    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void getBannerSuccess(ArrayList<Banner> bannerArrayList) {
        hideProgressDialog();
        mBannerArrayList.addAll(bannerArrayList);
        mScrollAdapter.notifyDataSetChanged();
    }

    @Override
    public void getUnopenedProjectSuccess(ArrayList<OpenSoonProjectData> openSoonProjectDataArrayList) {
        hideProgressDialog();
        mOpenSoonData.addAll(openSoonProjectDataArrayList);
        mOpenSoonProjectAdapter.notifyDataSetChanged();
    }

    @Override
    public void getBannerFailure(String message) {

    }

    @Override
    public void getUnopenedProjectFailure(String message) {

    }


}
