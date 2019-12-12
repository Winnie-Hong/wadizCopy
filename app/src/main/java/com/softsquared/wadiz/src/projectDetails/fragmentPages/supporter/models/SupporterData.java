package com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SupporterData {

    @SerializedName("supportResult")
    private ArrayList<SupportResultData> supportResultData;

    @SerializedName("cnt")
    private int cnt;


    public ArrayList<SupportResultData> getSupportResult() {
        return supportResultData;
    }

    public int getCnt() {
        return cnt;
    }
}
