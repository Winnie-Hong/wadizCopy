package com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.interfaces;

import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models.BannerResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RewardHomeRetrofitInterface {
//    @GET("/test")
    @GET("/banner")
    Call<BannerResponse> getBanner();

}
