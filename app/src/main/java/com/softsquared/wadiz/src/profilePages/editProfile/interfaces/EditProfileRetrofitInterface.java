package com.softsquared.wadiz.src.profilePages.editProfile.interfaces;

import com.softsquared.wadiz.src.profilePages.editProfile.models.EditProfileImgResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.PATCH;

public interface EditProfileRetrofitInterface {

    @FormUrlEncoded
    @PATCH("/profile/img")
    Call<EditProfileImgResponse> patchEditProfileImg(@Field("profileImg") String profileImg);
}
