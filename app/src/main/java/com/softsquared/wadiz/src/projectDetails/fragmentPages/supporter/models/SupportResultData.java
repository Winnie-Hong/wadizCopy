package com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter.models;

import com.google.gson.annotations.SerializedName;

public class SupportResultData {

    @SerializedName("userIdx")
    private int userIdx;

    @SerializedName("profileImg")
    private String profileImg;

    @SerializedName("veilName")
    private String veilName;

    @SerializedName("veilPrice")
    private String veilPrice;

    public int getUserIdx() {
        return userIdx;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public String getVeilName() {
        return veilName;
    }

    public String getVeilPrice() {
        return veilPrice;
    }
}
