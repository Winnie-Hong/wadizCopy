package com.softsquared.wadiz.src.projectDetails.rewardPolicy.models;

import com.google.gson.annotations.SerializedName;

public class FundPolicyData {

    @SerializedName("makerName")
    private String makerName;

    @SerializedName("rewardDate")
    private String rewardDate;

    @SerializedName("deliveryDate")
    private String deliveryDate;

    public String getMakerName() {
        return makerName;
    }

    public String getRewardDate() {
        return rewardDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }
}
