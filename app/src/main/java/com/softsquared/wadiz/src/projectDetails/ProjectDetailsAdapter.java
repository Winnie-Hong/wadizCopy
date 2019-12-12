package com.softsquared.wadiz.src.projectDetails;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.softsquared.wadiz.src.projectDetails.fragmentPages.community.ProjectCommunityFragment;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.fundGuide.ProjectFundGuideFragment;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.news.ProjectNewsFragment;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.reward.ProjectRewardFragment;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.StoryFragment;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter.ProjectSupporterFragment;

public class ProjectDetailsAdapter extends FragmentPagerAdapter {

    int mNumberOfPages;

    public ProjectDetailsAdapter(@NonNull FragmentManager fm) {
        super(fm);
        this.mNumberOfPages = 6;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position<0 || position>=mNumberOfPages){
            return null;
        }
        switch (position){
            case 0:
                return new StoryFragment();
            case 1:
                return new ProjectRewardFragment();
            case 2:
                return new ProjectFundGuideFragment();
            case 3:
                return new ProjectNewsFragment();
            case 4:
                return new ProjectCommunityFragment();
            case 5:
                return new ProjectSupporterFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumberOfPages;
    }

    private String[] pageTitle={
            "스토리",
            "리워드",
            "펀딩 안내",
            "새소식",
            "커뮤니티",
            "서포터"
    };

    public CharSequence getPageTitle(int position){
        if(pageTitle[position]!=null){
            return pageTitle[position];
        }
        else
            return null;
    }
}
