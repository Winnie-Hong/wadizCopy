package com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models;

        import com.google.gson.annotations.SerializedName;
        import java.util.ArrayList;

public class RewardProjectResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private ArrayList<RewardProjectData> result;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public ArrayList<RewardProjectData> getResult() {
        return result;
    }

}
