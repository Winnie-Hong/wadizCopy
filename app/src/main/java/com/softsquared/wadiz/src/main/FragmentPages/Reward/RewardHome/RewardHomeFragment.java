package com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.interfaces.RewardHomeFragmentView;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.Banner;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.CategoryData;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.RewardProjectData;

import java.util.ArrayList;

import pl.pzienowicz.autoscrollviewpager.AutoScrollViewPager;

public class RewardHomeFragment extends BaseFragment implements RewardHomeFragmentView {

    private AutoScrollViewPager mAutoViewPager;
    private ArrayList<Banner> mBannerArrayList;
    private AutoScrollAdapter mScrollAdapter;

    private ArrayList<CategoryData> mCategoryData;
    private ArrayList<RewardProjectData> mRewardProjectData;

    private RecyclerView mCategoryView;
    private CategoryAdapter mCategoryAdapter;
    private LinearLayoutManager mLayoutManager;

    private RecyclerView mRewardProjectView;
    private RewardProjectAdapter mRewardProjectAdapter;
    private LinearLayoutManager mProjectLayoutManager;

    private Button mShowAll;
    private Button mOrderBy;
    private ImageView mMenu;
    private EditText mSearchProject;

    private int MAX_CATEGORY_COUNT = 17;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_rewardhome, container, false);

        mShowAll = view.findViewById(R.id.btn_showall);
        mOrderBy = view.findViewById(R.id.btn_orderby);
        mMenu = view.findViewById(R.id.btn_menu);
        mSearchProject = view.findViewById(R.id.fragment_reward_home_et_search);

        final int[] selectItem = {0};
        mOrderBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] oItems = {"추천순", "인기순", "펀딩액순", "마감임박순", "최신순", "응원참여자순"};

                final AlertDialog.Builder oDialog = new AlertDialog.Builder(getActivity(),
                        android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);
                oDialog.setSingleChoiceItems(oItems, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String orderBy;
                        selectItem[0] = which;
                        mRewardProjectData.clear();
                        mRewardProjectAdapter.notifyItemRangeRemoved(0, mRewardProjectData.size());
                        switch (which) {
                            case 1:
                                orderBy = "famous";
                                break;
                            case 2:
                                orderBy = "funding";
                                break;
                            case 3:
                                orderBy = "deadline";
                                break;
                            case 4:
                                orderBy = "newp";
                                break;
                            case 5:
                                orderBy = "supporter";
                                break;
                            default:
                                orderBy = "recommend";
                                break;
                        }
                        getRewardProject(orderBy);
//                        showCustomToast(getActivity(),orderby);
                        dialog.dismiss();
                        mOrderBy.setText(oItems[which]);
                    }
                })
                        .setCancelable(true)
                        .show();
            }
        });

        //banner
        mBannerArrayList = new ArrayList<>(); //이미지 url를 저장하는 arraylist
        mAutoViewPager = view.findViewById((R.id.fragment_reward_home_vp_banner));
        mScrollAdapter = new AutoScrollAdapter(getActivity(), mBannerArrayList);
        mAutoViewPager.setAdapter(mScrollAdapter); //Auto Viewpager에 Adapter 장착
        mAutoViewPager.startAutoScroll();
        mAutoViewPager.setInterval(3000);

        getBanner();
        getCategory();
        getRewardProject("recommend");

        //category recycler view
        mCategoryView = view.findViewById(R.id.recyclerview_category);
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
//        showCustomToast(getActivity(), mRewardProjectData.size() + "");
        mRewardProjectView.setAdapter(mRewardProjectAdapter);

        //search
        mSearchProject.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId) {
                    case EditorInfo.IME_ACTION_SEARCH:
                        String word = v.getText().toString();
//                        showCustomToast(getActivity(), word);
                        mRewardProjectData.clear();
                        getSearchProject(word);
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });

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

    private void getRewardProject(String orderby) {
        showProgressDialog(getActivity());
        final RewardHomeService rewardHomeService = new RewardHomeService(this);
        rewardHomeService.getRewardProject(orderby);
    }

    private void getSearchProject(String word) {
        showProgressDialog(getActivity());
        final RewardHomeService rewardHomeService = new RewardHomeService(this);
        rewardHomeService.getSearchProject(word);
    }

    public void validateSuccess(String text) {
        hideProgressDialog();
    }

    public void validateFailure(String message) {
        showCustomToast(getActivity(), message == null || message.isEmpty() ? getString(R.string.network_error) : message);
        Log.d("tag", message);
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
        mRewardProjectData.addAll(rewardProjectData);
        mRewardProjectAdapter.notifyDataSetChanged();
    }

    @Override
    public void getSearchProjectSuccess(ArrayList<RewardProjectData> rewardProjectData) {
        hideProgressDialog();
        mRewardProjectData.addAll(rewardProjectData);
        mRewardProjectAdapter.notifyDataSetChanged();
    }

}
