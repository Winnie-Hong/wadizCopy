package com.softsquared.wadiz.src.main.FragmentPages.Reward.OpenSoon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.OpenSoon.interfaces.OpenSoonFragmentView;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.OpenSoon.models.AutoScrollAdapter;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.OpenSoon.models.OpenSoonService;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.Banner;


import java.util.ArrayList;

import pl.pzienowicz.autoscrollviewpager.AutoScrollViewPager;

public class OpenSoonFragment extends BaseFragment implements OpenSoonFragmentView {

    AutoScrollViewPager autoViewPager;
    ArrayList<Banner> mBannerArrayList;
    AutoScrollAdapter mScrollAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opensoon, container, false);

        mBannerArrayList = new ArrayList<>(); //이미지 url를 저장하는 arraylist
        autoViewPager = view.findViewById((R.id.view_pager));
        mScrollAdapter = new AutoScrollAdapter(getActivity(), mBannerArrayList);
        autoViewPager.setAdapter(mScrollAdapter); //Auto Viewpager에 Adapter 장착
        autoViewPager.startAutoScroll(5000);

        getBanner();

        return view;
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



}
