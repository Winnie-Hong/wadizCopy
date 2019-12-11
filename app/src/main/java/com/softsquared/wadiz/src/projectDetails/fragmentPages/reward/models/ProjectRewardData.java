package com.softsquared.wadiz.src.projectDetails.fragmentPages.reward.models;

import com.google.gson.annotations.SerializedName;

public class ProjectRewardData {

    @SerializedName("rewardIdx")
    private int rewardIdx;

    @SerializedName("rewardPrice")
    private String rewardPrice;

    @SerializedName("rewardName")
    private String rewardName;

    @SerializedName("rewardInfo")
    private String rewardInfo;

    @SerializedName("shipping")
    private String shipping;

    @SerializedName("quantity")
    private String quantity;

    @SerializedName("remaining")
    private String remaining;

    @SerializedName("completion")
    private String completion;

    public int getRewardIdx() {
        return rewardIdx;
    }

    public String getRewardPrice() {
        return rewardPrice;
    }

    public String getRewardName() {
        return rewardName;
    }

    public String getRewardInfo() {
        return rewardInfo;
    }

    public String getShipping() {
        return shipping;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getRemaining() {
        return remaining;
    }

    public String getCompletion() {
        return completion;
    }
}
