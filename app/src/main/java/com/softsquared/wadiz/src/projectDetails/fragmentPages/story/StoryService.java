package com.softsquared.wadiz.src.projectDetails.fragmentPages.story;

import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.interfaces.StoryFragmentView;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.interfaces.StoryRetrofitInterface;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.models.ProjectStoryResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class StoryService {
    private final StoryFragmentView mStoryFragmentView;

    StoryService(final StoryFragmentView storyFragmentView) {
        this.mStoryFragmentView = storyFragmentView;
    }


    void getProjectDetails(int projectIdx) {
        final StoryRetrofitInterface storyRetrofitInterface = getRetrofit().create(StoryRetrofitInterface.class);
        storyRetrofitInterface.getProjectDetails(projectIdx).enqueue(new Callback<ProjectStoryResponse>() {
            @Override
            public void onResponse(Call<ProjectStoryResponse> call, Response<ProjectStoryResponse> response) {
                final ProjectStoryResponse projectStoryResponse = response.body();
                if (projectStoryResponse == null) {
                    mStoryFragmentView.validateFailure(null);
                    return;
                }else if(projectStoryResponse.getCode() == 200){
                    mStoryFragmentView.getProjectDetailsSuccess(projectStoryResponse.getResult());
                    return;
                }
                mStoryFragmentView.validateFailure(projectStoryResponse.getMessage());
            }

            @Override
            public void onFailure(Call<ProjectStoryResponse> call, Throwable t) {
                mStoryFragmentView.validateFailure(null);
            }
    });
    }
}
