package com.softsquared.wadiz.src.main.FragmentPages.Reward.OpenSoon.interfaces;

import com.softsquared.wadiz.src.main.FragmentPages.Reward.OpenSoon.models.OpenSoonProjectResponse;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.BannerResponse;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.CategoryResponse;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.RewardProjectResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenSoonRetrofitInterface {

    @GET("/banner")
    Call<BannerResponse> getBanner();

    @GET("/project/unopened")
    Call<OpenSoonProjectResponse> getUnopenedProject();

}
