package com.softsquared.wadiz.src.projectDetails.fragmentPages.reward.interfaces;

import com.softsquared.wadiz.src.projectDetails.fragmentPages.reward.models.ProjectRewardResponse;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.models.ProjectStoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RewardRetrofitInterface {

    @GET("/project/{projectIdx}/reward")
    Call<ProjectRewardResponse> getProjectReward(@Path("projectIdx") int projectIdx);
}
