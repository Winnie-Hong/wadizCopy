package com.softsquared.wadiz.src.projectDetails.interfaces;

import com.softsquared.wadiz.src.projectDetails.models.ProjectDetailsResponse;
import com.softsquared.wadiz.src.signUp.models.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ProjectDetailsRetrofitInterface {

    @GET("/project/{projectIdx}/basic")
    Call<ProjectDetailsResponse> getProjectDetails(@Path("projectIdx") int projectIdx);
}
