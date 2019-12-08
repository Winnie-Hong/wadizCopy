package com.softsquared.wadiz.src.main.FragmentPages.Reward.OpenSoon.models;

import com.google.gson.annotations.SerializedName;

public class OpenSoonProjectData {

    @SerializedName("projectIdx")
    private int projectIdx;

    @SerializedName("thumnail")
    private String thumnail;

    @SerializedName("title")
    private String title;

    @SerializedName("makerName")
    private String makerName;

    @SerializedName("expected")
    private String expected;

    public int getProjectIdx() {
        return projectIdx;
    }

    public String getThumnail() {
        return thumnail;
    }

    public String getTitle() {
        return title;
    }

    public String getMakerName() {
        return makerName;
    }

    public String getExpected() {
        return expected;
    }
}
