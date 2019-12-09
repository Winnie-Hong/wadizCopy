package com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class    SearchProjectData {

    @SerializedName("cnt")
    private int cnt;

    @SerializedName("projectResult")
    private ArrayList<RewardProjectData> projectResult;

    public int getCnt() {
        return cnt;
    }

    public ArrayList<RewardProjectData> getProjectResult() {
        return projectResult;
    }

}
