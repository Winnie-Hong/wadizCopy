package com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models;

import com.google.gson.annotations.SerializedName;

public class RewardProjectData {

    @SerializedName("projectIdx")
    private int projectIdx;

    @SerializedName("thumnail")
    private String thumnail;

    @SerializedName("title")
    private String title;

    @SerializedName("category")
    private String category;

    @SerializedName("makerName")
    private String makerName;

    @SerializedName("achievement")
    private String achievement;

    @SerializedName("amount")
    private String amount;

    @SerializedName("remaining")
    private String remaining;

    public int getProjectIdx() {
        return projectIdx;
    }

    public String getThumnail() {
        return thumnail;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getMakerName() {
        return makerName;
    }

    public String getAchievement() {
        return achievement;
    }

    public String getAmount() {
        return amount;
    }

    public String getRemaining() {
        return remaining;
    }
}
