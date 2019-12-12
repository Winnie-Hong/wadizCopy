package com.softsquared.wadiz.src.projectDetails.rewardPolicy.models;

import com.google.gson.annotations.SerializedName;

public class FundPolicyResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private FundPolicyData result;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public FundPolicyData getResult() {
        return result;
    }

}