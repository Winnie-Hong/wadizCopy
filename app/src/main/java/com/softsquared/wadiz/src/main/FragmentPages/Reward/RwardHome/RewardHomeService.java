package com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome;

import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.interfaces.RewardHomeFragmentView;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.interfaces.RewardHomeRetrofitInterface;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models.BannerResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class RewardHomeService {
    private final RewardHomeFragmentView mRewardHomeFragmentView;

    RewardHomeService(final RewardHomeFragmentView rewardHomeFragmentView) {
        this.mRewardHomeFragmentView = rewardHomeFragmentView;
    }

    void getBanner() {
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
}
