package com.softsquared.wadiz.src.projectDetails.rewardPolicy;

import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.interfaces.StoryFragmentView;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.interfaces.StoryRetrofitInterface;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.models.ProjectStoryResponse;
import com.softsquared.wadiz.src.projectDetails.rewardPolicy.interfaces.FundPolicyRetrofitInterface;
import com.softsquared.wadiz.src.projectDetails.rewardPolicy.interfaces.FundPolicyView;
import com.softsquared.wadiz.src.projectDetails.rewardPolicy.models.FundPolicyResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class FundPolicyService {
    private final FundPolicyView mFundPolicyView;

    FundPolicyService(final FundPolicyView fundPolicyView) {
        this.mFundPolicyView = fundPolicyView;
    }


    void getFundPolicy(int projectIdx) {
        final FundPolicyRetrofitInterface fundPolicyRetrofitInterface = getRetrofit().create(FundPolicyRetrofitInterface.class);
        fundPolicyRetrofitInterface.getFundPolicy(projectIdx).enqueue(new Callback<FundPolicyResponse>() {
            @Override
            public void onResponse(Call<FundPolicyResponse> call, Response<FundPolicyResponse> response) {
                final FundPolicyResponse fundPolicyResponse = response.body();
                if (fundPolicyResponse == null) {
                    mFundPolicyView.validateFailure(null);
                    return;
                }else if(fundPolicyResponse.getCode() == 200){
                    mFundPolicyView.getFundPolicySuccess(fundPolicyResponse.getResult());
                    return;
                }
                mFundPolicyView.validateFailure(fundPolicyResponse.getMessage());
            }

            @Override
            public void onFailure(Call<FundPolicyResponse> call, Throwable t) {
                mFundPolicyView.validateFailure(null);
            }
    });
    }
}
