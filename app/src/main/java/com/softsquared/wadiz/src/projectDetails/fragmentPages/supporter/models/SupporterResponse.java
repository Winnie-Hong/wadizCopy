package com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter.models;

import com.google.gson.annotations.SerializedName;

public class SupporterResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private SupporterData result;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public SupporterData getResult() {
        return result;
    }


}