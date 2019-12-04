package com.softsquared.wadiz.src.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.softsquared.wadiz.src.main.FragmentPages.Home.EarlyBird;
import com.softsquared.wadiz.src.main.FragmentPages.Home.Exhibition;
import com.softsquared.wadiz.src.main.FragmentPages.Home.Maker;
import com.softsquared.wadiz.src.main.FragmentPages.Home.Recommend;
import com.softsquared.wadiz.src.main.FragmentPages.Home.Trend;

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
                return new Recommend();
            case 1:
                return new EarlyBird();
            case 2:
                return new Exhibition();
            case 3:
                return new Trend();
            case 4:
                return new Maker();
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
