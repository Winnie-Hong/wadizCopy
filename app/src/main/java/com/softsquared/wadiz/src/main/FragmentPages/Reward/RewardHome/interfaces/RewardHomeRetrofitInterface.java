package com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.interfaces;

import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.BannerResponse;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.CategoryResponse;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.RewardProjectResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RewardHomeRetrofitInterface {

    @GET("/banner")
    Call<BannerResponse> getBanner();

    @GET("/category")
    Call<CategoryResponse> getCategory();

    @GET("/project")
    Call<RewardProjectResponse> getRewardProject(
            @Query("orderby")  String orderby
    );

}
