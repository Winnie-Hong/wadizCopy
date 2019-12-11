package com.softsquared.wadiz.src.projectDetails.fragmentPages.reward;

import com.softsquared.wadiz.src.projectDetails.fragmentPages.reward.interfaces.RewardFragmentView;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.reward.interfaces.RewardRetrofitInterface;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.reward.models.ProjectRewardResponse;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.interfaces.StoryFragmentView;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.interfaces.StoryRetrofitInterface;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.models.ProjectStoryResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class ProjectRewardService {
    private final RewardFragmentView mRewardFragmentView;

    ProjectRewardService(final RewardFragmentView rewardFragmentView) {
        this.mRewardFragmentView = rewardFragmentView;
    }


    void getProjectReward(int projectIdx) {
        final RewardRetrofitInterface rewardRetrofitInterface = getRetrofit().create(RewardRetrofitInterface.class);
        rewardRetrofitInterface.getProjectReward(projectIdx).enqueue(new Callback<ProjectRewardResponse>() {
            @Override
            public void onResponse(Call<ProjectRewardResponse> call, Response<ProjectRewardResponse> response) {
                final ProjectRewardResponse projectRewardResponse = response.body();
                if (projectRewardResponse == null) {
                    mRewardFragmentView.validateFailure(null);
                    return;
                }else if(projectRewardResponse.getCode() == 200){
                    mRewardFragmentView.getProjectRewardSuccess(projectRewardResponse.getResult());
                    return;
                }
                mRewardFragmentView.validateFailure(projectRewardResponse.getMessage());
            }

            @Override
            public void onFailure(Call<ProjectRewardResponse> call, Throwable t) {
                mRewardFragmentView.validateFailure(null);
            }
    });
    }
}
