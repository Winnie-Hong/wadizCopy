package com.softsquared.wadiz.src.projectDetails;

import android.util.Log;

import com.softsquared.wadiz.src.projectDetails.interfaces.ProjectDetailsActivityView;
import com.softsquared.wadiz.src.projectDetails.interfaces.ProjectDetailsRetrofitInterface;
import com.softsquared.wadiz.src.projectDetails.models.ProjectDetailsResponse;
import com.softsquared.wadiz.src.signUp.interfaces.SignUpActivityView;
import com.softsquared.wadiz.src.signUp.interfaces.SignUpRetrofitInterface;
import com.softsquared.wadiz.src.signUp.models.SignUpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class ProjectDetailsService {
    private final ProjectDetailsActivityView mProjectDetailsActivityView;

    ProjectDetailsService(final ProjectDetailsActivityView projectDetailsActivityView) {
        this.mProjectDetailsActivityView = projectDetailsActivityView;
    }


    void getProjectDetails(int projectIdx) {
        final ProjectDetailsRetrofitInterface projectDetailsRetrofitInterface = getRetrofit().create(ProjectDetailsRetrofitInterface.class);
        projectDetailsRetrofitInterface.getProjectDetails(projectIdx).enqueue(new Callback<ProjectDetailsResponse>() {
            @Override
            public void onResponse(Call<ProjectDetailsResponse> call, Response<ProjectDetailsResponse> response) {
                final ProjectDetailsResponse projectDetailsResponse = response.body();
                if (projectDetailsResponse == null) {
                    mProjectDetailsActivityView.validateFailure(null);
                    return;
                }else if(projectDetailsResponse.getCode() == 200){
                    mProjectDetailsActivityView.getProjectDetailsSuccess(projectDetailsResponse.getResult());
                    return;
                }
                mProjectDetailsActivityView.validateFailure(projectDetailsResponse.getMessage());
            }

            @Override
            public void onFailure(Call<ProjectDetailsResponse> call, Throwable t) {
                mProjectDetailsActivityView.validateFailure(null);
            }
    });
    }
}
