package com.softsquared.wadiz.src.projectDetails.models;

import com.google.gson.annotations.SerializedName;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.CategoryData;

import java.util.ArrayList;

public class ProjectDetailsResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private ProjectDetailsData result;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public ProjectDetailsData getResult() {
        return result;
    }


}