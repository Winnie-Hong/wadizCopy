package com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models;

import com.google.gson.annotations.SerializedName;

public class Banner {
    @SerializedName("bannerIdx")
    private int bannerIdx;

    @SerializedName("bannerText")
    private String bannerText;

    @SerializedName("bannerSub")
    private String bannerSub;

    @SerializedName("bannerImg")
    private String bannerImg;

    public int getBannerIdx() {
        return bannerIdx;
    }

    public String getBannerText() {
        return bannerText;
    }

    public String getBannerSub() {
        return bannerSub;
    }

    public String getBannerImg() {
        return bannerImg;
    }

}