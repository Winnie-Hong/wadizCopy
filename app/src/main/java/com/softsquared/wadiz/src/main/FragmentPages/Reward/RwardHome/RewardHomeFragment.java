package com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.interfaces.RewardHomeFragmentView;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models.Banner;

import java.util.ArrayList;

import pl.pzienowicz.autoscrollviewpager.AutoScrollViewPager;

public class RewardHomeFragment extends BaseFragment implements RewardHomeFragmentView {

    AutoScrollViewPager autoViewPager;
    ArrayList<Banner> mBannerArrayList;
    AutoScrollAdapter mScrollAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_rewardhome, container, false);
        mBannerArrayList = new ArrayList<>(); //이미지 url를 저장하는 arraylist
        autoViewPager = view.findViewById((R.id.view_pager));
        mScrollAdapter = new AutoScrollAdapter(getActivity(), mBannerArrayList);
        autoViewPager.setAdapter(mScrollAdapter); //Auto Viewpager에 Adapter 장착

        autoViewPager.startAutoScroll(3000);

        getBanner();
        return view;

    }

    private void getBanner() {
        showProgressDialog(getActivity());
        final RewardHomeService rewardHomeService = new RewardHomeService(this);
        rewardHomeService.getBanner();
    }

    public void validateSuccess(String text) {
        hideProgressDialog();

    }

    public void validateFailure(@Nullable String message) {
        showCustomToast(getActivity(), message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    @Override
    public void getBannerSuccess(ArrayList<Banner> bannerArrayList) {
        hideProgressDialog();
//        for(int i=0; i<bannerArrayList.size(); i++){
//            Log.d("title", bannerArrayList.get(i).getBannerText());
//        }
//        bannerArrayList
        mBannerArrayList.addAll(bannerArrayList);
        mScrollAdapter.notifyDataSetChanged();
    }


}
