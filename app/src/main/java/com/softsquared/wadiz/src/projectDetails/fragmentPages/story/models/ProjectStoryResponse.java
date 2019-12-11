package com.softsquared.wadiz.src.projectDetails.fragmentPages.story.models;

import com.google.gson.annotations.SerializedName;

public class ProjectStoryResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private ProjectStoryData result;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public ProjectStoryData getResult() {
        return result;
    }


}