package com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter.interfaces;

import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.models.ProjectStoryResponse;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter.models.SupporterResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SupporterRetrofitInterface {

    @GET("/project/{projectIdx}/supporter")
    Call<SupporterResponse> getSupporter(@Path("projectIdx") int projectIdx);
}
