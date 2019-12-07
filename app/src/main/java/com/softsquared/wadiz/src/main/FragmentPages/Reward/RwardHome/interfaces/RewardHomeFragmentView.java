package com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.interfaces;

import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models.Banner;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models.CategoryData;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models.RewardProjectData;

import java.util.ArrayList;

public interface RewardHomeFragmentView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void getBannerSuccess(ArrayList<Banner> bannerArrayList);

    void getCategorySuccess(ArrayList<CategoryData> categoryDataArrayList);

    void getRewardProjectSuccess(ArrayList<RewardProjectData> rewardProjectData);
}