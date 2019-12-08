package com.softsquared.wadiz.src.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.softsquared.wadiz.src.main.FragmentPages.Reward.GlobalFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.OpenSoon.OpenSoonFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.RewardHomeFragment;

public class MyPagerAdapter_to_Reward extends FragmentPagerAdapter {
    int mNumOfPages;

    public MyPagerAdapter_to_Reward(FragmentManager fm) {
        super(fm);
        this.mNumOfPages = 3;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) { ///
            case 0:
                return new RewardHomeFragment();
            case 1:
                return new OpenSoonFragment();
            case 2:
                return new GlobalFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfPages;
    }

    private String[] pageTitle={
            "리워드홈",
            "오픈예정",
            "글로벌"
    };

    @Override
    public CharSequence getPageTitle(int position){
        if(pageTitle[position]!=null)
            return pageTitle[position];
        else
            return null;
    }

}
