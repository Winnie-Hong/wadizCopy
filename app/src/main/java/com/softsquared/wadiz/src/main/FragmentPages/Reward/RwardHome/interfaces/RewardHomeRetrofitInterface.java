package com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.interfaces;

import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models.BannerResponse;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models.CategoryResponse;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models.RewardProjectResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
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
