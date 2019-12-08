package com.softsquared.wadiz.src.main.FragmentPages.Reward.OpenSoon.models;

import com.softsquared.wadiz.src.main.FragmentPages.Reward.OpenSoon.interfaces.OpenSoonFragmentView;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.OpenSoon.interfaces.OpenSoonRetrofitInterface;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.BannerResponse;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

public class  OpenSoonService {
    private final OpenSoonFragmentView mOpenSoonFragmentView;

    public OpenSoonService(final OpenSoonFragmentView openSoonFragmentView) {
        this.mOpenSoonFragmentView = openSoonFragmentView;
    }

    public void getBanner() {
        final OpenSoonRetrofitInterface openSoonRetrofitInterface = getRetrofit().create(OpenSoonRetrofitInterface.class);
        openSoonRetrofitInterface.getBanner().enqueue(new Callback<BannerResponse>() {
            @Override
            public void onResponse(Call<BannerResponse> call, Response<BannerResponse> response) {
                final BannerResponse bannerResponse = response.body();
                if (bannerResponse == null) {
                    mOpenSoonFragmentView.validateFailure(null);
                    return;
                } else if (bannerResponse.getCode() == 200) {
                    mOpenSoonFragmentView.getBannerSuccess(bannerResponse.getResult());
                    return;
                }
                mOpenSoonFragmentView.validateFailure(bannerResponse.getMessage());
            }

            @Override
            public void onFailure(Call<BannerResponse> call, Throwable t) {
                mOpenSoonFragmentView.validateFailure(null);
            }
        });
    }


}
