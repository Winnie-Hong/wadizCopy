package com.softsquared.wadiz.src.projectDetails.rewardPolicy.interfaces;

import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.Banner;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.CategoryData;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.RewardProjectData;
import com.softsquared.wadiz.src.projectDetails.rewardPolicy.models.FundPolicyData;

import java.util.ArrayList;

public interface FundPolicyView {

    void getFundPolicySuccess(FundPolicyData fundPolicyData);

    void validateFailure(String message);



}