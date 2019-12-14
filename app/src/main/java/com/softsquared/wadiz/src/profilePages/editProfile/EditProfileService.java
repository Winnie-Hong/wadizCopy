package com.softsquared.wadiz.src.profilePages.editProfile;

import android.util.Log;

import com.google.gson.JsonObject;
import com.softsquared.wadiz.src.profilePages.editProfile.interfaces.EditProfileRetrofitInterface;
import com.softsquared.wadiz.src.profilePages.editProfile.interfaces.EditProfileView;
import com.softsquared.wadiz.src.profilePages.editProfile.models.EditProfileDetailsResponse;
import com.softsquared.wadiz.src.profilePages.editProfile.models.EditProfileImgResponse;
import com.softsquared.wadiz.src.profilePages.editProfile.models.EditProfileItems;

import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.MEDIA_TYPE_JSON;
import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class EditProfileService {
    private final EditProfileView mEditProfileView;

    EditProfileService(final EditProfileView editProfileView) {
        this.mEditProfileView = editProfileView;
    }


    void patchEditProfileImg(final String profileImg) {
        final EditProfileRetrofitInterface editProfileRetrofitInterface = getRetrofit().create(EditProfileRetrofitInterface.class);
        editProfileRetrofitInterface.patchEditProfileImg(profileImg).enqueue(new Callback<EditProfileImgResponse>() {
            @Override
            public void onResponse(Call<EditProfileImgResponse> call, Response<EditProfileImgResponse> response) {
                final EditProfileImgResponse editProfileImgResponse = response.body();
                if (editProfileImgResponse == null) {
                    mEditProfileView.validateFailure(null);

                    return;
                }else if(editProfileImgResponse.getCode() == 200){
                    mEditProfileView.patchProfileImgSuccess(editProfileImgResponse.getMessage(), editProfileImgResponse.getMessage());
                    Log.d("tag", editProfileImgResponse.getMessage());
                    return;
                }
                mEditProfileView.validateFailure(editProfileImgResponse.getMessage());
            }


            @Override
            public void onFailure(Call<EditProfileImgResponse> call, Throwable t) {
                mEditProfileView.validateFailure(null);
            }
        });
    }


    void patchEditProfileDetails(EditProfileItems editProfileItems) {
        final EditProfileRetrofitInterface editProfileRetrofitInterface = getRetrofit().create(EditProfileRetrofitInterface.class);
        editProfileRetrofitInterface.patchEditProfileDetails(editProfileItems).enqueue(new Callback<EditProfileDetailsResponse>() {
            @Override
            public void onResponse(Call<EditProfileDetailsResponse> call, Response<EditProfileDetailsResponse> response) {
                final EditProfileDetailsResponse editProfileDetailsResponse = response.body();
//                Log.d("details tag", response.body().getCode()+"");
//                Log.d("details tag", response.body().toString());
                if (editProfileDetailsResponse == null) {
                    mEditProfileView.validateFailure(null);
                    return;
                }else if(editProfileDetailsResponse.getCode() == 200){
                    mEditProfileView.patchProfileDetailsSuccess(editProfileDetailsResponse.getMessage(), editProfileDetailsResponse.getMessage());
                    return;
                }else if(editProfileDetailsResponse.getCode() == 201) {
                    mEditProfileView.patchProfileDetailsSuccess(editProfileDetailsResponse.getMessage(), editProfileDetailsResponse.getMessage());
                    return;
                }
                else if(editProfileDetailsResponse.getCode() == 202) {
                    mEditProfileView.patchProfileDetailsSuccess(editProfileDetailsResponse.getMessage(), editProfileDetailsResponse.getMessage());
                    return;
                }else{
                    mEditProfileView.validateFailure(editProfileDetailsResponse.getMessage());
                }
            }


            @Override
            public void onFailure(Call<EditProfileDetailsResponse> call, Throwable t) {
                mEditProfileView.validateFailure(null);
            }
        });
    }

}
