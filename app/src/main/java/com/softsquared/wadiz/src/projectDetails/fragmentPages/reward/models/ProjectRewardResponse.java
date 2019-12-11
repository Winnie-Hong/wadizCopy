package com.softsquared.wadiz.src.projectDetails.fragmentPages.reward.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProjectRewardResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private ArrayList<ProjectRewardData> result;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public  ArrayList<ProjectRewardData>  getResult() {
        return result;
    }


}