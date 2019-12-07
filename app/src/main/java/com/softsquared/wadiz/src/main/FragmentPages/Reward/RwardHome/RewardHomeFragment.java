package com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.interfaces.RewardHomeFragmentView;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models.Banner;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models.CategoryData;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models.RewardProjectData;

import java.util.ArrayList;

import pl.pzienowicz.autoscrollviewpager.AutoScrollViewPager;

public class RewardHomeFragment extends BaseFragment implements RewardHomeFragmentView {

    AutoScrollViewPager autoViewPager;
    ArrayList<Banner> mBannerArrayList;
    AutoScrollAdapter mScrollAdapter;

    ArrayList<CategoryData> mCategoryData;
    ArrayList<RewardProjectData> mRewardProjectData;

    private RecyclerView mCategoryView;
    private CategoryAdapter mCategoryAdapter;
    private LinearLayoutManager mLayoutManager;

    private RecyclerView mRewardProjectView;
    private RewardProjectAdapter mRewardProjectAdapter;
    private LinearLayoutManager mProjectLayoutManager;

    Button mshowAll;
    Button mOrderby;
    ImageView mMenu;
    String mOrderbySelected;

    private int MAX_CATEGORY_COUNT = 17;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rewardhome, container, false);

        mshowAll = view.findViewById(R.id.btn_showall);
        mOrderby = view.findViewById(R.id.btn_orderby);
        mMenu = view.findViewById(R.id.btn_menu);

        final int[] selectItem = {0};
        mOrderby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] oItems = {"추천순", "인기순", "펀딩순", "마감임박순", "최신순", "응원참여자수"};

                final AlertDialog.Builder oDialog = new AlertDialog.Builder(getActivity(),
                        android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);
                oDialog.setSingleChoiceItems(oItems, 0, new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                selectItem[0] = which;
                            }
                        })
                        .setCancelable(true)
                        .show();
            }
        });

        //banner
        mBannerArrayList = new ArrayList<>(); //이미지 url를 저장하는 arraylist
        autoViewPager = view.findViewById((R.id.view_pager));
        mScrollAdapter = new AutoScrollAdapter(getActivity(), mBannerArrayList);
        autoViewPager.setAdapter(mScrollAdapter); //Auto Viewpager에 Adapter 장착
        autoViewPager.startAutoScroll(5000);

        getBanner();
        getCategory();
        getRewardProject();

        //category recycler view
        mCategoryView = (RecyclerView) view.findViewById(R.id.recyclerview_category);
        mCategoryData = new ArrayList<>();

        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mCategoryView.setLayoutManager(mLayoutManager);
        mCategoryAdapter = new CategoryAdapter(getActivity(), mCategoryData);
        mCategoryView.setAdapter(mCategoryAdapter);

        //project recycler view

        mRewardProjectView = view.findViewById(R.id.recyclerview_home_project);
        mRewardProjectData = new ArrayList<>();

        mProjectLayoutManager = new LinearLayoutManager(getActivity());
        mProjectLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRewardProjectView.setLayoutManager(mProjectLayoutManager);
        mRewardProjectAdapter = new RewardProjectAdapter(getActivity(), mRewardProjectData);
        showCustomToast(getActivity(), mRewardProjectData.size() + "");
        mRewardProjectView.setAdapter(mRewardProjectAdapter);

        return view;

    }

    private void getBanner() {
        showProgressDialog(getActivity());
        final RewardHomeService rewardHomeService = new RewardHomeService(this);
        rewardHomeService.getBanner();
    }

    private void getCategory() {
        showProgressDialog(getActivity());
        final RewardHomeService rewardHomeService = new RewardHomeService(this);
        rewardHomeService.getCategory();
    }

    private void getRewardProject() {
        showProgressDialog(getActivity());
        final RewardHomeService rewardHomeService = new RewardHomeService(this);
        rewardHomeService.getRewardProject();
    }


    public void validateSuccess(String text) {
        hideProgressDialog();

    }

    public void validateFailure(String message) {
        showCustomToast(getActivity(), message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    @Override
    public void getBannerSuccess(ArrayList<Banner> bannerArrayList) {
        hideProgressDialog();
        mBannerArrayList.addAll(bannerArrayList);
        mScrollAdapter.notifyDataSetChanged();
    }

    @Override
    public void getCategorySuccess(ArrayList<CategoryData> categoryDataArrayList) {
        hideProgressDialog();
        mCategoryData.addAll(categoryDataArrayList);
        mCategoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void getRewardProjectSuccess(ArrayList<RewardProjectData> rewardProjectData) {
        hideProgressDialog();

        for (int i = 0; i < mRewardProjectData.size(); i++) {
            Log.d("title", mRewardProjectData.get(i).getTitle());
        }

        mRewardProjectData.addAll(rewardProjectData);
        mRewardProjectAdapter.notifyDataSetChanged();
    }


}
