package com.softsquared.wadiz.src.profilePages.editProfile.interfaces;

import com.softsquared.wadiz.src.profilePages.editProfile.models.EditProfileDetailsResponse;
import com.softsquared.wadiz.src.profilePages.editProfile.models.EditProfileImgResponse;
import com.softsquared.wadiz.src.profilePages.editProfile.models.EditProfileItems;

import java.util.ArrayList;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;

public interface EditProfileRetrofitInterface {

    @FormUrlEncoded
    @PATCH("/profile/img")
    Call<EditProfileImgResponse> patchEditProfileImg(@Field("profileImg") String profileImg);

    @PATCH("/profile")
    Call<EditProfileDetailsResponse> patchEditProfileDetails(@Body EditProfileItems data);

}
