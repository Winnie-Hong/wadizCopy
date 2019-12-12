package com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter;

import android.util.Log;

import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.interfaces.StoryFragmentView;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.interfaces.StoryRetrofitInterface;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.models.ProjectStoryResponse;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter.interfaces.SupporterFragmentView;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter.interfaces.SupporterRetrofitInterface;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter.models.SupporterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class SupporterService {
    private final SupporterFragmentView mSupporterFragmentView;

    SupporterService(final SupporterFragmentView supporterFragmentView) {
        this.mSupporterFragmentView = supporterFragmentView;
    }


    void getSupporter(final int projectIdx) {
        final SupporterRetrofitInterface supporterRetrofitInterface = getRetrofit().create(SupporterRetrofitInterface.class);
        supporterRetrofitInterface.getSupporter(projectIdx).enqueue(new Callback<SupporterResponse>() {
            @Override
            public void onResponse(Call<SupporterResponse> call, Response<SupporterResponse> response) {
                final SupporterResponse supporterResponse = response.body();
                if (supporterResponse == null) {
                    mSupporterFragmentView.validateFailure(null);
                    return;
                }else if(supporterResponse.getCode() == 200){
                    mSupporterFragmentView.getSupporterSuccess(supporterResponse.getResult());
                    Log.d("supporter", "서비스 통신성공");
                    return;
                }
                mSupporterFragmentView.validateFailure(supporterResponse.getMessage());
            }

            @Override
            public void onFailure(Call<SupporterResponse> call, Throwable t) {
                mSupporterFragmentView.validateFailure(null);
            }
    });
    }


}
