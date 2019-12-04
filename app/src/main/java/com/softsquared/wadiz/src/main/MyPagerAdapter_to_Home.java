package com.softsquared.wadiz.src.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.softsquared.wadiz.src.main.FragmentPages.Home.EarlyBirdFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Home.ExhibitionFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Home.MakerFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Home.RecommendFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Home.TrendFragment;

public class MyPagerAdapter_to_Home extends FragmentPagerAdapter {
    int mNumOfPages;

    public MyPagerAdapter_to_Home(FragmentManager fm) {
        super(fm);
        this.mNumOfPages = 5;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new RecommendFragment();
            case 1:
                return new EarlyBirdFragment();
            case 2:
                return new ExhibitionFragment();
            case 3:
                return new TrendFragment();
            case 4:
                return new MakerFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfPages;
    }

    private String[] pageTitle={
            "추천",
            "얼리버드",
            "기획전",
            "트렌드",
            "메이커"
    };

    @Override
    public CharSequence getPageTitle(int position){
        if(pageTitle[position]!=null)
            return pageTitle[position];
        else
            return null;
    }

}
