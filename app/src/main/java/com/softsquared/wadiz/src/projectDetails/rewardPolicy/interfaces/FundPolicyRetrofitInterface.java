package com.softsquared.wadiz.src.projectDetails.rewardPolicy.interfaces;

import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.BannerResponse;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.CategoryResponse;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.RewardProjectResponse;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.SearchProjectResponse;
import com.softsquared.wadiz.src.projectDetails.rewardPolicy.models.FundPolicyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FundPolicyRetrofitInterface {

    @GET("/project/{projectIdx}/policy")
    Call<FundPolicyResponse> getFundPolicy(@Path("projectIdx") int projectIdx);

}
