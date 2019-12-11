package com.softsquared.wadiz.src.projectDetails.fragmentPages.story.interfaces;

import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.models.ProjectStoryResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StoryRetrofitInterface {

    @GET("/project/{projectIdx}/basic")
    Call<ProjectStoryResponse> getProjectDetails(@Path("projectIdx") int projectIdx);
}
