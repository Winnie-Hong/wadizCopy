package com.softsquared.wadiz.src.main.FragmentPages.Reward.OpenSoon.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OpenSoonProjectResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private ArrayList<OpenSoonProjectData> result;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public ArrayList<OpenSoonProjectData> getResult() {
        return result;
    }

}
