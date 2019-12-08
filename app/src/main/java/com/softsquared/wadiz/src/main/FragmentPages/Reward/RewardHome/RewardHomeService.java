package com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome;

import android.util.Log;

import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.interfaces.RewardHomeFragmentView;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.interfaces.RewardHomeRetrofitInterface;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.BannerResponse;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.CategoryResponse;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.RewardProjectResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class RewardHomeService {
    private final RewardHomeFragmentView mRewardHomeFragmentView;

    RewardHomeService(final RewardHomeFragmentView rewardHomeFragmentView) {
        this.mRewardHomeFragmentView = rewardHomeFragmentView;
    }

    public void getBanner() {
        final RewardHomeRetrofitInterface rewardHomeRetrofitInterface = getRetrofit().create(RewardHomeRetrofitInterface.class);
        rewardHomeRetrofitInterface.getBanner().enqueue(new Callback<BannerResponse>() {
            @Override
            public void onResponse(Call<BannerResponse> call, Response<BannerResponse> response) {
                final BannerResponse bannerResponse = response.body();
                if (bannerResponse == null) {
                    mRewardHomeFragmentView.validateFailure(null);
                    return;
                } else if (bannerResponse.getCode() == 200) {
                    mRewardHomeFragmentView.getBannerSuccess(bannerResponse.getResult());
                    return;
                }
                mRewardHomeFragmentView.validateFailure(bannerResponse.getMessage());
            }

            @Override
            public void onFailure(Call<BannerResponse> call, Throwable t) {
                mRewardHomeFragmentView.validateFailure(null);
            }
        });
    }

    void getCategory(){
        final RewardHomeRetrofitInterface rewardHomeRetrofitInterface = getRetrofit().create(RewardHomeRetrofitInterface.class);
        rewardHomeRetrofitInterface.getCategory().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                final CategoryResponse getCategory = response.body();
                if (getCategory == null) {
                    mRewardHomeFragmentView.validateFailure(null);
                    return;
                } else if (getCategory.getCode() == 200) {
                    mRewardHomeFragmentView.getCategorySuccess(getCategory.getResult());
                    return;
                }
                mRewardHomeFragmentView.validateFailure(getCategory.getMessage());
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                mRewardHomeFragmentView.validateFailure(null);
            }
        });
    }

    public void getRewardProject(final String orderby) {
        final RewardHomeRetrofitInterface rewardHomeRetrofitInterface = getRetrofit().create(RewardHomeRetrofitInterface.class);
        rewardHomeRetrofitInterface.getRewardProject(orderby).enqueue(new Callback<RewardProjectResponse>() {
            @Override
            public void onResponse(Call<RewardProjectResponse> call, Response<RewardProjectResponse> response) {
                final RewardProjectResponse getRewardProject = response.body();
                if (getRewardProject == null) {
                    mRewardHomeFragmentView.validateFailure(null);
                    return;
                } else if (getRewardProject.getCode() == 200) {
                    mRewardHomeFragmentView.getRewardProjectSuccess(getRewardProject.getResult());
                    return;
                }
                mRewardHomeFragmentView.validateFailure(getRewardProject.getMessage());
            }

            @Override
            public void onFailure(Call<RewardProjectResponse> call, Throwable t) {
                mRewardHomeFragmentView.validateFailure(null);
            }
        });
    }
}
