package com.softsquared.wadiz.src.main.FragmentPages.Reward.OpenSoon.interfaces;

import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.Banner;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.CategoryData;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.RewardProjectData;

import java.util.ArrayList;

public interface OpenSoonFragmentView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void getBannerSuccess(ArrayList<Banner> bannerArrayList);


}