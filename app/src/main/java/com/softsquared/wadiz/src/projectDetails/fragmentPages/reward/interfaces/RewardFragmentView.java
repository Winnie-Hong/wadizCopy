package com.softsquared.wadiz.src.projectDetails.fragmentPages.reward.interfaces;

import com.softsquared.wadiz.src.projectDetails.fragmentPages.reward.models.ProjectRewardData;

import java.util.ArrayList;

public interface RewardFragmentView {

    void validateFailure(String message);
    void getProjectRewardSuccess(ArrayList<ProjectRewardData> projectRewardData);
}
