package com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.interfaces;

import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.Banner;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.CategoryData;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.RewardProjectData;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.SearchProjectData;

import java.util.ArrayList;

public interface RewardHomeFragmentView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void getBannerSuccess(ArrayList<Banner> bannerArrayList);

    void getCategorySuccess(ArrayList<CategoryData> categoryDataArrayList);

    void getRewardProjectSuccess(ArrayList<RewardProjectData> rewardProjectData);

    void getSearchProjectSuccess(ArrayList<RewardProjectData> rewardProjectData);

}