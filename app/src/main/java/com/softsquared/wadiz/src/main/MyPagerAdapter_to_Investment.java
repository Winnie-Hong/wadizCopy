package com.softsquared.wadiz.src.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.softsquared.wadiz.src.main.FragmentPages.Investment.Bond;
import com.softsquared.wadiz.src.main.FragmentPages.Investment.CulturalContents;
import com.softsquared.wadiz.src.main.FragmentPages.Investment.InvestHome;
import com.softsquared.wadiz.src.main.FragmentPages.Investment.InvestOpenSoon;
import com.softsquared.wadiz.src.main.FragmentPages.Investment.Startup;
import com.softsquared.wadiz.src.main.FragmentPages.Investment.Survey;
import com.softsquared.wadiz.src.main.FragmentPages.Investment.W9;

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
                return new Survey();
            case 1:
                return new InvestHome();
            case 2:
                return new InvestOpenSoon();
            case 3:
                return new Startup();
            case 4:
                return new CulturalContents();
            case 5:
                return new Bond();
            case 6:
                return new W9();
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
