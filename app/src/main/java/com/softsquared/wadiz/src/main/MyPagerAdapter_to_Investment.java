package com.softsquared.wadiz.src.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.softsquared.wadiz.src.main.FragmentPages.Investment.BondFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Investment.CulturalContentsFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Investment.InvestHomeFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Investment.InvestOpenSoonFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Investment.StartupFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Investment.SurveyFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Investment.WFragment;

public class MyPagerAdapter_to_Investment extends FragmentPagerAdapter {
    int mNumOfPages;

    public MyPagerAdapter_to_Investment(FragmentManager fm) {
        super(fm);
        this.mNumOfPages = 7;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SurveyFragment();
            case 1:
                return new InvestHomeFragment();
            case 2:
                return new InvestOpenSoonFragment();
            case 3:
                return new StartupFragment();
            case 4:
                return new CulturalContentsFragment();
            case 5:
                return new BondFragment();
            case 6:
                return new WFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfPages;
    }

    private String[] pageTitle={
            "수요조사",
            "투자 홈",
            "오픈 예정",
            "스타트업",
            "문화콘텐츠",
            "채권",
            "W9"
    };

    @Override
    public CharSequence getPageTitle(int position){
        if(pageTitle[position]!=null)
            return pageTitle[position];
        else
            return null;
    }

}
