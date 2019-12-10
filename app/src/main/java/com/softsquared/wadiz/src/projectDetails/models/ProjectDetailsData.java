package com.softsquared.wadiz.src.projectDetails.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProjectDetailsData {

    @SerializedName("thumnail")
    private String thumbnail;

    @SerializedName("title")
    private String title;

    @SerializedName("category")
    private String category;

    @SerializedName("infoText")
    private String infoText;

    @SerializedName("goal")
    private String goal;

    @SerializedName("term")
    private String term;

    @SerializedName("supprterCnt")
    private String supporterCnt;

    @SerializedName("makerName")
    private String makerName;

    @SerializedName("makerImg")
    private String makerImg;

    @SerializedName("facebook")
    private String facebook;

    @SerializedName("instagram")
    private String instagram;

    @SerializedName("projectStory")
    private String projectStory;


    public String getThumbnail() {
        return thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getInfoText() {
        return infoText;
    }

    public String getGoal() {
        return goal;
    }

    public String getTerm() {
        return term;
    }

    public String getSupporterCnt() {
        return supporterCnt;
    }

    public String getMakerName() {
        return makerName;
    }

    public String getMakerImg() {
        return makerImg;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getProjectStory() {
        return projectStory;
    }
}
